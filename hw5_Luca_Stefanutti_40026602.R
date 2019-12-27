#1.a.
SummitCreek<-read.csv("sumcr.csv", header = TRUE, stringsAsFactors = FALSE)
class(SummitCreek)
dim(SummitCreek)
#Type: data.frame, dimensions: 88 rows, 11 columns

#b.This new record will be the average cumulative distance 
#downstream from upstream
SummitCreek[,12]<-NA

SumLength<-0
CountofLengths<-1
average<-0
names(SummitCreek)[12]<-"average CumLen"

#The for loop goes through SummitCreek by row calculating the 
#average of the CumLen and attributing it to the new column
for(r in 1:nrow(SummitCreek)){
 SumLength<-SumLength+SummitCreek[r,4]
 CountofLengths<-CountofLengths+1
 average<-SumLength/(CountofLengths-1)
 SummitCreek[r,12]<-average
}

#c.Create Column 13 for Bedrocktype
SummitCreek[,13]<-NA
names(SummitCreek)[13]<-"BedrockType"

#created more than just granite as data :) 
granite<-rep("granite",22)
basalt<-rep("basalt",22)
mudstone<-rep("mudstone",22)
marble<-rep("marble",22)

#the for loop goes through SummitCreek by row
#adding 22 of each type of Bedrocktype to all the rows in the
#new column
for(r in 1:nrow(SummitCreek)){
  if(r>=1 & r<=22){
    SummitCreek[r,13]<-granite[r]
  }else if(r>22 & r<=44){
    #notice that for basalt r has to be decreased by 22
    #this is because once r reaches 23 in the loop, there
    #are no values in basalt which has a range 1:22, so 
    #subtracting 22 from r ensures it loops through the 22
    #elements of basalt
    SummitCreek[r,13]<-basalt[r-22]
  }else if(r>44 & r<=66){
    #same logic for mudstone and marble
    SummitCreek[r,13]<-mudstone[r-44]
  }else{
    SummitCreek[r,13]<-marble[r-66]
  }
}

#d.
attach(SummitCreek)
CumLen

class(HU)
length(HU)

#e.
plot(CumLen, WidthWS, main = "CumLen vs WidthWS and WidthBF", 
     xlab = "CumLen (m)", ylab = "WidthWS and WidthBF (m)", pch = 15,
     col = "cyan", ylim = c(1,20), cex = 1.10)

points(WidthBF, pch = 4, col = "darkgoldenrod", cex = 1.10)

legend(locator(1), legend=c("WidthWS","WidthBF"), pch=c(15,4),
       col=c("cyan","darkgoldenrod"))
#f.
HydroUnits<-c("P","R","G")

#g.
Pools<-0
Riffles<-0
Glides<-0

#This for loop goes over every entry of HU
#if that entry is equal to "P" then it is added to Pools
#same logic for "R" and "G"
for(r in 1:length(HU)){
  if(HU[r]==HydroUnits[1]){
    Pools<-Pools+1
  }else if(HU[r]==HydroUnits[2]){
    Riffles<-Riffles+1
  }else if(HU[r]==HydroUnits[3]){
    Glides<-Glides+1
  }
}
Riffles
Pools
Glides

HydroUnits<-c(Pools,Riffles,Glides)
HydroUnits

#h.
barplot(HydroUnits, col="darkblue", main = "HydroUnits", ylab="Frequency of given HydroUnit",
        names.arg = c("Pools", "Riffles", "Glides"), ylim=c(0,40))

#i.
write.csv(SummitCreek,file="SummitCreekEX.csv")

#j.
detach(SummitCreek)

#2.a)
Raw<-read.csv("QuebecTemp.csv", header=FALSE, stringsAsFactors = FALSE)
Raw<-Raw[-1:-2,]
#For some reason the values contained in, Raw when not being read as Factors, were 
#instead characters, I had to force convert them to numeric
#using apply
Raw<-matrix(apply(Raw, c(1,2), as.numeric), 141, 13)

#This function creates an empty vector, then using the empty
#vector, takes the means of entire columns of Raw
#assigning it to the vector
MeanMonths<-function(raw){
  mean_vector_months<-rep(NA,12) 
  for (c in 2:ncol(raw)){
    mean_vector_months[c-1]<-mean(raw[,c])
  }
  return(mean_vector_months)
}

AvrMonths<-MeanMonths(Raw)
AvrMonths

#b.
#Axis for some reason seems to refuse to change all the axes
#to months so I will keep it as a 1:12
MonthlyMeanPlot<-function(Vector){
  Months<-c("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec")
  plot(1:12,Vector[1:12],type="l", main = "Average Monthly Temperatures 
       from 1877-2017", xlab="Months", ylab="Temperatures in Degrees Celcius")
  #axis(1,at=1:12, labels = c(Months[1:12]))
}

MonthlyMeanPlot(AvrMonths)

#c.Hotmonths was recycled from the old assignment and transformed
#into a function which returns a vector length 2
HotMonths<-function(raw){
 
  NumHotMonths<-0
  
  SumHM<-0
  
  for (r in 1:141){
    for(c in 2:13){
      if((raw[r,c])>=(20)){
        NumHotMonths<-((NumHotMonths)+(1))
        SumHM<-((SumHM)+(raw[r,c]))
      }
    }
  }
  AverageHM<-SumHM/NumHotMonths
  
  return(c(NumHotMonths, AverageHM))
}

HotMonths(Raw)

#d.Cold Months was also recycled from the previous homework
#and turned into a function that returns a vector of length 2
ColdMonths<-function(raw){
  
  NumColdMonths<-0
  
  SumCM<-0
  
  for(r in 1:141){
    for(c in 2:13){
      if((raw[r,c])<=(-13)){
        NumColdMonths<-((NumColdMonths)+(1))
        SumCM<-((SumCM)+(raw[r,c]))
      }
    }
  }
  
  AverageCM<-SumCM/NumColdMonths
  
  return(c(NumColdMonths, AverageCM))
  
}

ColdMonths(Raw)

#e.The extended funtion creates an empty matrix called
#Completed. 
Extended<-function(raw){
  
  Completed<-matrix(NA, nrow=141, ncol=14)
  
  #looping through each row and column, when the loop reaches
  #the 14th column it takes the average of all the months in Raw
  #the given year (which corresponds to rows both in Raw and Completed) and assigns it
  #to the 14th column in Completed
  #else if it is not 14 it just assigns normally each value of Raw to Completed
  for (r in 1:nrow(Completed)){
    for (c in 1:ncol(Completed)){
      if (c==14){
        Completed[r,c]<-mean(raw[r,2:13])
      }else{
        Completed[r,c]<-raw[r,c]
      }
    }
  }
  
  return(Completed)
}

#The function is then assigned to complete in order to obtain the
#values from the local scope of the function
Completed<-Extended(Raw)

#f.
AnnualPlot<-function(Completed){
  
  plot(seq(1877,2017, by=1), Completed[,14], main = "Average Temperatures per Year", xlab="Years 1877-2017", 
       ylab = "Average Temperatures in Degrees Celcius")
}

AnnualPlot(Completed)

#g

write.csv(Completed,"Completed.csv")

 