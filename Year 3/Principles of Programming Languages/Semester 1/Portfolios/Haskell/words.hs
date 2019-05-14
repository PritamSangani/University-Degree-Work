{- Portfolio - implement a Haskell program which reads some text from a file and displays some word statistics:
1) The total number of words in the text.
2) The total number of the top 20 most commonly used English words that appears in the text according
to the Oxford English Corpus (OEC) rank. See the list in Figure 3.
3) A histogram of the top 20 most frequent words in the text excluding common words.
-}
import Data.Char
import Data.List

commonWords :: [String]
commonWords = ["the", "be", "to", "of", "and", "a", "in", "that", "have", "i", "it", "for", "not", "on", "with", "he", "as", "you", "do", "at"]

toLowerString :: String -> String
toLowerString =  map toLower

toWordList :: String -> [String]
toWordList = words . (filter (\x -> isLower x || isSpace x)) . toLowerString

countCommonWords :: [String] -> Int
countCommonWords = length . filter (\x -> x `elem` commonWords)

dropCommonWords :: [String] -> [String]
dropCommonWords = filter (\x -> x `notElem` commonWords)

getWordTuple :: [String] -> (String, Int)
getWordTuple lst = (head lst, length lst)

groupWords :: [String] -> [[String]]
groupWords = (group . sort)

countWords :: [String] -> [(String, Int)]
countWords = map (\x -> getWordTuple x) . groupWords

sortTuples (a, b) (c, d)
  | b < d = GT
  | b > d = LT
  | b == d = compare c a
  
sortWords :: [(String, Int)] -> [(String, Int)]
sortWords = sortBy sortTuples

makeHistogramRow :: (String, Int) -> String
makeHistogramRow tpl =  concat (replicate (snd tpl) "*") ++ " -> " ++ (fst tpl) ++ "\n"

makeHistogram :: [(String, Int)] -> String
makeHistogram = concat . map (\x -> makeHistogramRow x) . take 20

text = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way--in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only.\nThere were a king with a large jaw and a queen with a plain face, on the throne of England; there were a king with a large jaw and a queen with a fair face, on the throne of France. In both countries it was clearer than crystal to the lords of the State preserves of loaves and fishes, that things in general were settled for ever."

main = do
  let wordlist = toWordList text
  putStrLn "Report:"
  putStrLn ("\t" ++ (show $ length wordlist) ++ " words")
  putStrLn ("\t" ++ (show $ countCommonWords wordlist) ++ " common words")
  putStrLn "\nHistogram of the most frequent words (excluding common words):\n"
  putStr $ makeHistogram $ sortWords $ countWords $ dropCommonWords $ wordlist