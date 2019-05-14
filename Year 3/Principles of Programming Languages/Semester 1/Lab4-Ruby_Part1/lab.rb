# Ex. 1a - print line number before each line
puts("Ex. 1a\n")
counter = 0
File.open("lyrics.txt", "r") do |infile|
    while line = infile.gets
        counter+=1
        puts "#{counter}: #{line}"
    end
    puts "\n"
end

# Ex. 1b - reverse each line
puts("Ex. 1b\n")
counter = 0
File.open("lyrics.txt", "r") do |infile|
    while line = infile.gets
        counter+=1
        puts "#{counter}: #{line.chomp('').reverse}"
    end
    puts("\n")
end

# Ex. 1c - reverse order of words instead of letters
puts("Ex. 1c\n")
counter = 0
File.open("lyrics.txt", "r") do |infile|
    while line = infile.gets
        counter+=1
        puts "#{counter}: #{line.split(' ').reverse.join(' ')}"
    end
    puts("\n")
end

# Ex. 2 - program that displays number of occurences of each word
puts("Ex. 2")
words = Hash.new(0)
File.open("lyrics.txt", "r") do |infile|
    while line = infile.gets
        line.split.each do |word|
            word = word.sub(',', '')
            if words.has_key?(word)
                words[word] = words[word] + 1
            else
                words[word] = 1
            end
        end 
    end
    words.each {|word, occurences| puts "#{word.ljust(8)} occurred #{occurences} times"}
    puts("\n")
end

# Ex. 3 - print all odd numbers between 0 and 50
puts("Ex. 3\n")
puts (0..50).select { |a| a % 2 == 1 }
puts("\n")

# Ex. 4 - only print words longer than minLength
puts("Ex. 4")
minLength = 7
words = []
File.open("words.txt", "r") do |infile|
    while (word = infile.gets)
        words << word
    end
end
words = words.select { |a| a.length >= minLength }
puts "There are #{words.length} words longer than #{minLength} letters."
puts("\n")

# Ex. 5a - FizzBuzz program between 1 and 200
puts "Ex. 5a"
for i in 1..200 do
    if i%5 == 0 && i%3 == 0
        puts "FizzBuzz"
    elsif i%3 == 0
        puts "Fizz"
    elsif i%5 == 0
        puts "Buzz"
    else
        puts i
    end
end
puts "\n"

# Ex. 5b - implement Ex. 5a again but using map method
puts "Ex. 5b"
puts (1..200).map { |i| 
    if i%5 == 0 && i%3 == 0
        i = "FizzBuzz"
    elsif i%3 == 0
        i = "Fizz"
    elsif i%5 == 0
        i = "Buzz"
    else
        i
    end
}  
puts "\n"

# Ex. 6 - Extension : Project Euler - Problem 17
