QCTemp<-read.csv("QuebecTempTrunc.csv")
dim(QCTemp)

#1

#This will create a vector filled with temporary 0s
#repeating an equivalent amount of times with the dimensions
#of the matrix
QCTempVector<-rep(0,(nrow(QCTemp)*ncol(QCTemp)))



#this count will be used for the index of the vector
count<-1

#The double for loop will loop through the rows of
#QuebecTempTrunc and the columns, assigning r 1, c 1 to index
#1 of the vector, then r 1, c 2, to index 2 of the vector so on
#so forth
for(r in 1:nrow(QCTemp)){
  for(c in 1:ncol(QCTemp)){
    QCTempVector[count]<-QCTemp[r,c]
    count<-count+1
  }
}

#The function ts will take the values of the vector
#seperate the values by months using the frequency set to
#12 and will begin in the year 1942, adding + 1 to the year
#at the end when December is reached
Yrs<-ts(QCTempVector[1:180], frequency = 12, start = 1942)
Yrs

#The code to make the plot for the years 1942-1956
plot(Yrs, type="l", ylim=c(-15,25), xlim=c(1942,1956), lwd=2, xlab="Years 1942 till 1956",
     ylab="Temperature in Degrees Celcius", main="Monthly Temperatures for 1942 until 1956")
#The graph is pretty repetative going from cold extremes of -12~-13
#in the winter to 21~22 degrees in summer 1947 and 1954 seem like
#the coldest years, while 1953 seems like the warmest


#2

#prompt the user to enter the number of years to run the simulation which will
#then be converted to an integer
nbYearsinput<-readline("Enter the number of years the simulation will run for, else enter 0: ")
nbYears<-as.integer(nbYearsinput)


#The while loop will contiously loop back to entering the values of the 
#lynxes and hares so long as the number of years does not equal 0
while(nbYears!=0){
  
  #same code as to put in the number of years
  nbLynxesinput<-readline("Enter the number of lynxes in the 1st year: ")
  nbLynxes<-as.integer(nbLynxesinput)
  
  nbHaresinput<-readline("Enter the number of hares in the 1st year: ")
  nbHares<-as.integer(nbHaresinput)

  #The fo loop will be responsible for carrying out the equations
  #and printing out the appropriate values
  for(y in 1:nbYears){
    
    #the equations to calculate the number of baby lynxes and dead ones
    #as well as the number of baby hares, eaten and dead
    nbBabyLynxes<-round(nbLynxes*0.15)
    nbDeadLynxes<-round(nbLynxes*0.02)
    if((nbLynxes/nbHares)>=0.20){
      nbDeadLynxes<-round(nbLynxes*0.50)
      }
    
    nbBabyHares<-round(nbHares*0.75)
    nbDeadHares<-round(nbHares*0.01)
    nbEatenHares<-round(nbLynxes*nbHares*0.025)
    
    #this will print out the header of the table
    if(y==1){
      print("Year #Hare #Lynxes babyH babyL deadH deadL #Eaten")
      
    }
    
    
    #The garph printed at the end of the simulation, it basically plugs
    #in the number of lynxes and hares during each year into the plot
    #i.e. on year 1 the graph will only have points at 20 and 1000
    #for the simulation with 20 Lynxes and 1000 Hares, as the years go by
    #new points are added. I have to admit I am unsure on how to trasform this into a 
    #line graph.
    if(y==1){
      plot(y, nbLynxes, type="p", xlim=c(1,40), ylim=c(0,1600),col="blue", main="Number of Lynxes and Hares 
           through the years", xlab="Years starting from 1", ylab="number of Hares and Lynxes")
      points(y, nbHares, type="p",col="red")
      legend("topright", legend=c("Lynxes","Hares"), pch=c(1,1),
             col=c("blue", "red"))
    }else if(y>1){
      points(y, nbLynxes, type="p",col="blue")
      points(y, nbHares, type="p",col="red")
    }
    
    
    #This if statement occurs if the number of current hares plus the number of baby hares
    #is less than the ones dead and being eaten, resulting in a 
    #negative number of hares
    if(round(((nbHares+nbBabyHares)-(nbDeadHares+nbEatenHares)))<=0){
      #if such is the case, the number of eaten hares is the entire population of that given year
      nbEatenHares<-nbHares+nbBabyHares
     }
    
    
    #I had initially wanted to make all these values into a matrix since it would
    #print out more nicely, but I was not aware to what extent
    #I was able to go outside the instructions, instead I sought to
    #obtain a table similar to the example in the assignment but each time mine is 
    #printed out it is not correctly  formatted and time grows short on other assignments
    #but it does print out all the relevant data in a table like structure
    cat("      ",y,"   ",nbHares,"   ", nbLynxes,"   ",nbBabyHares,
        "  ",nbBabyLynxes,"  ",nbDeadHares,"   ",
        nbDeadLynxes,"   ",nbEatenHares,"\n")
    
  #The nb of lynxes and hares changes after the inital value is entered so that the next year
  #the nb of lynxes and hares changes 
    nbLynxes<-round(((nbLynxes+nbBabyLynxes)-(nbDeadLynxes)))
    nbHares<-round(((nbHares+nbBabyHares)-(nbDeadHares+nbEatenHares)))
    
    #A special if statement that I included (not mentioned in the instructions) making use of the modulo
    #operator. I ran multiple simulations where all the hares would be 
    #eaten and a single lynx would live on for an eternity
    #in this case, if there is one lynx left and it lives to 
    #any number of year that is a multiple of 7 (lynxes have a lifespan of 7 years)
    #the simulation ends and prints out when the last lynx died
    if((nbLynxes==1)&(y%%7==0)){
      cat("The Last of the Lynxes has died on the",y,"st/th year")
      break
      }
    
    #This is linked to if all the hares have been killed or eaten, it sets them to 0
    #Although I will admit I do not know why R still computes
    #nbLynxes/nbHares from the equation to know how many Lynxes starve
    #division by 0 ought not to be possible
    if(round(((nbHares+nbBabyHares)-(nbDeadHares+nbEatenHares)))<=0){
      nbHares<-nbHares*0
    }
  }
  
  
  
  #At the end of the simulation we once more ask the user whether he/she
  #wishes to restart the simulation, thus giving he/she a chance
  nbYearsinput<-readline("If you wish to try again, enter the number of years the simulation will run for, else enter 0: ")
  nbYears<-as.integer(nbYearsinput)
  
}