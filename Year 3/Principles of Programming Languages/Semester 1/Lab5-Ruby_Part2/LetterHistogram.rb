# PORTFOLIO - LetterHistogram class
# TODO: [x] one getter/setter attribute : text (String)
#       [x] check if 'text' is a string
#       [x] private method : calculateFrequencies - computes frequency of each letter in 'text' and returns output as hash
#       [x] method : display - displays for each letter A-Z (inc. letters not in 'text') a row of asteriks representing frequency

# Things to note:
#    [x] - count lower and uppercase as the same letter
#    [x] - punctuation and special characters should be ignored
#    [x] - user should be able to initialise 'text' when LetterHistogram object is created
#    [x] - if initial value is not provided "Hello, World!" should be default value

class LetterHistogram
    DEFAULT = "Hello, World!"
    attr_accessor :text

    def initialize(text = DEFAULT)
        if(text.is_a? String)
            @text = text
        else
            puts "The text you have provided is not a String. The default value of 'Hello, World!' has been used."
            @text = DEFAULT
        end
    end

    def calculateFrequencies
        letters = Hash.new(0)
        string = @text.upcase.gsub(/[^A-Z]/, '')
        string.split("").each do |l|
            letters[l] += 1
        end

        return letters
    end

    def display
        lettersHash = calculateFrequencies
        ("A".."Z").each{ |letter|
            freq = lettersHash[letter]
            puts "#{letter}: #{'*'*freq}"
        }
    end

    private :calculateFrequencies
end