function [foo, num1] = part5_function(mynum)
    % this function contains some of the commands we executed previously
    % the percent sign '%' marks the start of a comment in a function
    mynum
    foo = 'bar'
    foo = 'bar';
    num1 = 7
    num2 = 7.0002
    num3 = num1 + num2
    myarray = [3 7 5 2 1 5 9]
    myarray(4) = 10
    myarray_min = min(myarray)
    myarray_max = max(myarray)
    myarray_average = mean(myarray)
    myarray_total = sum(myarray)
    myarray_sorted = sort(myarray)
    myarray_unique = unique(myarray)
end