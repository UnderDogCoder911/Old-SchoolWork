Raw<-read.csv("QuebecTemp.csv", header=FALSE)
dim(Raw)


#These mean functions will be used on every column (except the 1st) of Raw
#in order to get the average for every month 
Jan_Mean<-mean(Raw[,2])
paste("The Mean Temperature in January is: ", Jan_Mean)

Feb_Mean<-mean(Raw[,3])
paste("The Mean Temperature in Feburary is: ", Feb_Mean)

Mar_Mean<-mean(Raw[,4])
paste("The Mean Temperature in March is: ", Mar_Mean)

Apr_Mean<-mean(Raw[,5])
paste("The Mean Temperature in April is: ", Apr_Mean)

May_Mean<-mean(Raw[,6])
paste("The Mean Temperature in May is: ", May_Mean)

Jun_Mean<-mean(Raw[,7])
paste("The Mean Temperature in June is: ", Jun_Mean)

Jul_Mean<-mean(Raw[,8])
paste("The Mean Temperature in July is: ", Jul_Mean)

Aug_Mean<-mean(Raw[,9])
paste("The Mean Temperature in August is: ", Aug_Mean)

Sep_Mean<-mean(Raw[,10])
paste("The Mean Temperature in September is: ", Sep_Mean)

Oct_Mean<-mean(Raw[,11])
paste("The Mean Temperature in October is: ", Oct_Mean)

Nov_Mean<-mean(Raw[,12])
paste("The Mean Temperature in November is: ", Nov_Mean)

Dec_Mean<-mean(Raw[,13])
paste("The Mean Temperature in December is: ", Dec_Mean)


#Initializing both the number of Hot months and the sum of
#Hot month temperature to 0
NumHotMonths<-0

SumHM<-0

#The double for loop will go starting with the 1st row,
#through all the columns in order to count the number of 
#hot months where the temperature is above or equal to 20
for(r in 1:141){
  for(c in 2:13){
    if((Raw[r,c])>=(20)){
      NumHotMonths<-((NumHotMonths)+(1))
      SumHM<-((SumHM)+(Raw[r,c]))
      }
  }
}

#The sum of the temperatures will be divided by the number of hot months
#obtain the average
AverageHM<-SumHM/NumHotMonths

paste("The number of hot months is: ",NumHotMonths)

paste("The sum of hot months is: ",SumHM)

paste("The average temperature of hot months is: ",AverageHM)


#The same logic of hot months is used to find the cold months
#except that the condition is -13
NumColdMonths<-0

SumCM<-0

for(r in 1:141){
  for(c in 2:13){
    if((Raw[r,c])<=(-13)){
      NumColdMonths<-((NumColdMonths)+(1))
      SumCM<-((SumCM)+(Raw[r,c]))
    }
  }
}

AverageCM<-SumCM/NumColdMonths

paste("The number of cold months is: ",NumColdMonths)

paste("The sum of cold months is: ",SumCM)

paste("The average temperature of cold months is: ",AverageCM)


#creating the matrix extended and using a double for loop
#to assign every value of Raw to extended, leaving the 
#extra columns and rows unassigned
Extended<-matrix(,142,16)
for(r in 1:141){
  for(c in 1:13){
    Extended[r,c]<-Raw[r,c]
  }
}


#To create row 14 we first have to calculate the mean of the 1st year's
#January, Febuary and March which is then added to column 14 in the 1st row
AvrColdTemp1877<-mean(Extended[1,2:4])
Extended[1,14]<-AvrColdTemp1877

#The following for loop goes through all the rows(years) starting from the 2nd
for(r in 2:141){
  
  #Since the cold season is the previous November to the
  #March of the next year the index has to go back to the 1st row
  #take the values of that previous year and add them to the next year
  
  AvrColdTemp<-((Extended[(r-1),12])+(Extended[(r-1),13])+(Extended[r,2])+(Extended[r,3])+(Extended[r,4]))
  
  #note that there is no need to change the column number because we 
  #are only iterating through the years adding the value 
  #of the temperature of the months together
  #and dividing by 5 to obtain the average of a given year's
  #5 months of November to March inclusive
  
  #The values are then assigned to column 14
  
  Extended[r,14]<-((AvrColdTemp)/5)
}



for(r in 1:141){
  
  #The growing season is calculated in much the same as cold
  #except in this instance we do not have to go back to the 
  #previous year in order to obtain our values for the
  #months of April to October(5:11) for the growing season
  #The results are assigned to row 15 as specified
  
  AvrGrowSeason<-mean(Extended[r,(5:11)])
  Extended[r,15]<-AvrGrowSeason
}



for(r in 1:141){
  
  #The average annual temperature just takes the average of all
  #the month temperatures and divides by 12, assigning them to the last
  #column
  
  AvrAnnualTemp<-mean(Extended[r,2:13])
  Extended[r,16]<-AvrAnnualTemp
}


#This plots all the averages of the Cold Season
plot(Extended[1:141,1], Extended[1:141,14], main="Seasonal and annual temperatures 
over 141 years", xlab="Years 1877-2017", ylab="Seasonal and annual means",
xlim=c(1877, 2017), ylim=c(-12,25), col="blue", pch=8)

#These points are the Average growing season temperatures
points(Extended[1:141,1], Extended[1:141,15],pch=3, col="red")

#And these are the annual temperatures
points(Extended[1:141,1], Extended[1:141,16],pch=16, col="green")

legend("topright", legend=c("Growing Season Means", "Annual Means", "Cold Season Means"),
pch=c(3,16,8), col=c("red", "green", "blue"))


#The 142 row is assigned the means of all the individual months
#As well as the means for the average seasons cold + growing
#as well as annual
Extended[142,2]<-Jan_Mean

Extended[142,3]<-Feb_Mean

Extended[142,4]<-Mar_Mean

Extended[142,5]<-Apr_Mean

Extended[142,6]<-May_Mean

Extended[142,7]<-Jun_Mean

Extended[142,8]<-Jul_Mean

Extended[142,9]<-Aug_Mean

Extended[142,10]<-Sep_Mean

Extended[142,11]<-Oct_Mean

Extended[142,12]<-Nov_Mean

Extended[142,13]<-Dec_Mean

Extended[142,14]<-mean(Extended[1:141,14])

Extended[142,15]<-mean(Extended[1:141,15])

Extended[142,16]<-mean(Extended[1:141,16])



#makes a nice line plot for the 142nd row of all the averages
plot(c(1:12), Extended[142,2:13], ylim=c(-30,30), type="l",col="green", main="Annual monthly temperatures",
xlab="Months 1-12", ylab="Temperatures")




write.csv(Extended,"Extended.csv")
