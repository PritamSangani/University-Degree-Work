#TASK C

.data	#tells assembler that we're in data segment

	#variable declarations
	enterNo: .asciiz "\nEnter a three digit number: "
	result: .asciiz "\nThe result of your calculation is: "
	
	time: .asciiz "\nTotal time of calculation is: "
	ms: .asciiz " ms"
	
.text	#tells assembler that we're in text segment

	#print out enterNo string
	la $a0 enterNo		#load enterNo into $a0 register
	addi $v0 $zero 4	#load service number 4 (for printing a string) into $v0
	syscall			#call for system

	#read integer that user enters
	addi $v0 $zero 5	#load service number 5 (for reading an integer) into $v0 register
	syscall
	 
	move $t0 $v0	#move integer stored in $v0 register to $t0 register
	
	#get system time for just before loop structure begins
	li $v0 30		#load service number 30 (for system time) into $v0 register
	syscall		
	move $t5 $a0	#move time stamp data from $a0 into $t5 register
	
	#instructions for loop structure
	addi $t1 $zero 50 	#add 50 to $t1 (counter for loopOuter)
	loopOuter:
		addi $t3 $zero 100		#add 100 to $t3 (counter for loopInner1)
		loopInner1:
			addi $t4 $zero 500	#add 50 to $t4 (counter for loopInner2)
			loopInner2:	
				addi $t4 $t4 -1		#take 1 away from $t4 each time loopInner2 occurs
				div $t2 $t0 7		#divide number stored in $t0 (entered by user) by 7 and store answer in $t2
				bgez $t4 loopInner2		#if number in $t4 is greater than or equal to zero go back to loopInner2 label and rerun code within the loop 
		addi $t3 $t3 -1	
		bgez $t3 loopInner1	
	addi $t1 $t1 -1
	bgez $t1 loopOuter
	
	#get system time for just after loop structure has ended
	li $v0 30		#record timestamp for the end of the loop structure
	syscall
	move $t6 $a0
	
	#get total time for loop structure	
	sub $t7 $t6 $t5		#subtract $t5 from $t6 to get total time for the loop structure

	#print out result string
	la $a0 result		
	addi $v0 $zero 4
	syscall
	
	#print out result of calculation (integer)
	addi $v0 $zero 1
	move $a0 $t2
	syscall
	
	#print out time string
	la $a0 time
	addi $v0 $zero 4
	syscall
	
	#print out the total time for loop structure
	addi $v0 $zero 1
	move $a0 $t7
	syscall
	#print out ms string (displayed after total time)
	la $a0 ms
	addi $v0 $zero 4
	syscall
		
	
	
	
	
