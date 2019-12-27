#3) Write an if-statement that computes the absolute value of x

#assign any negative value of x, in this case -9 is arbitrarily chosen
x<-(-9)

#The absolute value of a number is always positive as a 
#result the condition must look whether x is negative

if (x<0){

#if x is negative then we must make it into a positive number  
#in this case -2*-9 will yeild 18, adding -9 to it will give 9
#giving us the absolute value

  x<- ((-2*x)+x)
  cat(x)
}

#4) Write an if statement that computes the signum of a numeric
#value x and assigns it to z

#create an arbitrary x variable
x<-(-100)

#create the first if statement which will assign 1 to z if
#x is bigger than 0, printing z in the process
if (x>0){
  z<-(1)
  cat(z)

#If the 1st if-statement is false it will move on to the
#2nd condition of if x is equal to 0
}else if (x==0){
  z<-0
  cat(z)

#If the 2nd condition is not met then R will execute this 
#3rd and final statement assigning -1 to z if x is smaller
#than 0
}else if(x<0){
  z<-(-1)
  cat(z)
}

#5) Evaluate the logical expressions
i<-13
j<-12

#a will be False 2*13 is executed 1st then the condition is checked
((2*i)<j)

#b will be False 2*13 is executed 1st, then +1 is added, the result
#is bigger than 12
(((2*i)+1)<=j)

#c will be false, 12 <= 14 will be evaluated to true, but 
# j <= 6 will be false. The & condition will then be evaluated to False
#because both conditions must be true for & to be true
((i<=14)&(j<=6))

#d will be True. Both conditions will be evaluated to true and false
#like in c, but the | operator only requires 1 truth value in order
#to be evaluated to True
((i<=14)|(j<=6))

#e will be False, 13>0 is True, 12<=10 is false. True & False is False
((i>0)&(i<=10))

#f will be True, 13<=12 is False, 12<=12 is True, False | True is True
((i<=12)|(j<=12))

#g 13>25 will be False, 13<5 will be False 12<50 will be True
#through precedence, False & True will be False
#False | False will be False which is the final answer
((i>25)|((i<5)&(j<50)))

#h will be True, 13!=4 is True, 13!=5 is True, True & True is True
((i!=4)&(i!=5))

#i will be True, 13<14 is True, 13>5 is True, True | True is True
((i<14)|(i>5))

#j will be False, 13>10 is True, !(True) is False
!(i>10)


#6) Use a for-loop to compute the summing of 1/n^4 1000 times.

#initalize variable z
z<-0

#create the for loop where n is the index starting at 1 and going to 1000
for (n in 1:1000){
#in the 1st loop z will be (0 + (1/(1^4))) which is 1
#then n will increase by 1 and so now the loop will execute
#(1 + (1/(2^4))) which is 1.00625
#this pattern repeats 1000 times until we are left with the answer
  z<-(z+(1/(n^4)))
}
print(z)

#which in this case is 1.08232323337831


#7)

#use read function to acess the values
temperature<-read.csv("wintertemp.csv")

#initalize all variables to 0
Total_winterdays<-0
ex_cold<-0
cold<-0
moderate<-0
warm<-0
ab_warm<-0

#sum will be used for the average
sum<-0

#r is the nb of rows within the csvfile
r<-1

#starting from [row 1,col 1], the while loop goes through all the
#temperatures stored in the csvfile, disregarding -9999 because it
#is not an earthly temperature
while(temperature[r,1]!=(-9999.0)){
  
  #this keeps track of the total nb of winter days
  Total_winterdays<-Total_winterdays+1
  
  #These if-statements have the conditions as stipulated by homework2
  if(temperature[r,1]<(-20)){
    #keeps track of extremely cold days
    ex_cold<-ex_cold+1
    #adds the value of those temperatures to the sum to be used later
    sum<-sum+temperature[r,1]
  }
  
  if((temperature[r,1]>=(-20))&(temperature[r,1]<(-10))){
    #keeps track of nb of cold days
    cold<-cold+1
    #adds the value of those temperatures to the sum to be used later
    sum<-sum+temperature[r,1]
  }
  
  if((temperature[r,1]>=(-10)&(temperature[r,1]<(-5)))){
    #keeps track of nb of moderate days
    moderate<-moderate+1
    #adds the value of those temperatures to the sum to be used later
    sum<-sum+temperature[r,1]
  }
  
  if((temperature[r,1]>=(-5)&(temperature[r,1]<(0)))){
    #keeps track of nb of warm days
    warm<-warm+1
    #adds the value of those temperatures to the sum to be used later
    sum<-sum+temperature[r,1]
  }
  
  if((temperature[r,1]>=(0))){
    #keeps track of nb of abnormally warm days
    ab_warm<-ab_warm+1
    #values of abnormally warm days are not added to sum
    #we are looking for temperatures strictly smaller than 0
  }
  
  #r increases by 1 in order to loop through all the rows of the 
  #csv file
  r<-r+1
}

#the average is calculated with the sum of the temperatures
#divided by the nb of days Not abnormally warm
average<-sum/(warm+moderate+cold+ex_cold)

#The final print statements for each variable
print(Total_winterdays)

print(ex_cold)

print(cold)

print(moderate)

print(warm)

print(ab_warm)

print(average)



