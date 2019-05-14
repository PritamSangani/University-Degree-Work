# Ex. 1 - Implement Basic Employee class with instance variables for id and name
# Ex. 2 - Add a getSignature method to class which returns string with name and id
# Ex. 4 - make getSignature in Employee and Developer private and implement a new method called printSignature
class Employee

    attr_accessor :name
    attr_reader :id

    def initialize (id, name="John Smith")
        @id = id
        @name = name
    end

    def getSignature
        "Employee ID #{@id}: #{@name}"
    end

    def printSignature
        getSignature
    end

    private :getSignature
end

# Ex. 3 - Implement Developer class which extends Employee. Override getSignature method to add ", Developer" to the end
class Developer < Employee

    def getSignature
        super + ', Developer'
    end

    def printSignature
        getSignature
    end

    private :getSignature
end

