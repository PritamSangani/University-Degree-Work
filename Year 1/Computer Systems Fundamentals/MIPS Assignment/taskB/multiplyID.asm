#TASK B

.data	#tells assembler that we're in data segment

	#variable declarations
	enterID: .asciiz "Enter the last three digits of your student ID number: "
	printID: .asciiz "\nThe number you entered multiplied by 2 equals "

.text	#tells assembler that we're in text segment
	
	#print out enterID string
	la $a0 enterID		#load enterID variable into $a0 register
	addi $v0 $zero 4	#load service number 4 (for printing out a string) into $v0 register
	syscall			#call to system
	
	#read integer that user enters
	addi $v0 $zero 5	#load service number 5 (for reading an integer) into $v0 register
	syscall
	
	#move integer stored in $v0 register to $t0 register
	addu $t0 $zero $v0
	
	mul $t1 $t0 2		#multiply number in $t0 by 2 and store in $t1
	
	addi $t2 $zero 3	#add 3 to $t2
	
	loop:				#start of loop
	#print out printID string
	la $a0 printID
	addi $v0 $zero 4
	syscall
	
	#print out integer that was entered by user
	addi $v0 $zero 1	#load service number 1 (to print an integer) in $v0 register
	#move integer stored in $t1 register to $a0 register
	addu $a0 $zero $t1
	syscall
	
	addi $t2 $t2 -1		#take 1 away from number in $t2 each time it reaches this line
	bgez $t2 loop		#if number in $t2 is greater than or equal to zero go back to loop label and rerun code within the loop 
	
	
	
