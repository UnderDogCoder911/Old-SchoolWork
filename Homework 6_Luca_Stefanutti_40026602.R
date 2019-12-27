MtlDogs<-read.csv("MontrealDogs.csv", header=T, stringsAsFactors = FALSE)

Issue <- function(Dogdata){
  # This function issues a new dog license
  # Input: Dogdata - a data frame, it outputs the same
  
  
  # prompt clerk for needed information
  name <- readline(prompt="Enter the dog's name ")
  dog_breed <- readline(prompt="Enter the dog's breed ")
  dog_sex <- readline(prompt="Enter the dog's sex ")
  dog_owner <- readline(prompt="Enter the dog's owner ")
  owner_phone <- readline(prompt="Enter the owner's phone number ")
  
  # Figure out the new license number
  new_number <- max(Dogdata$license_number) + 1
  print(paste("The new license number is ",new_number))
  
  # build the new record and add it into database
  newrecord <- data.frame(dog_name = name, license_number = new_number, 
                          breed = dog_breed, sex = dog_sex, owner = dog_owner,
                          phone = owner_phone, criminal_record = c(F))
  
  Dogdata <- rbind(Dogdata,newrecord)
  
  return(Dogdata)  
}


#Takes Dog number and T, F ifbitten
Query<-function(DogNum, ifBitten){
  
  for (r in 1:nrow(MtlDogs)){
    
    #If the dog number matches a license number and the catcher was bitten
    if(DogNum == MtlDogs[r,2] & ifBitten == T){
     
      #False for criminal record becomes true 
      MtlDogs[r,7]<-TRUE
     
       #prints out the releavent info
      print(paste("The owner is: ", MtlDogs[r,5], " the phone number is: ", MtlDogs[r,6]))
      break
      
      #If Dog num matches the licence number again but that the bitten is false
      }else if(DogNum == MtlDogs[r,2] & ifBitten == F){
      #only the relevant info is printed
        print(paste("The owner is: ", MtlDogs[r,5], " the phone number is: ", MtlDogs[r,6]))
        break
      
        #a test condition in case the number inputted by the user
        #is higher than the number of actual liscences in the
        #data.frame
      }else if(DogNum > MtlDogs[nrow(MtlDogs),2] & ifBitten == T){
        
        #if it is true, you enter a name, breed and sex for the 
        #dog that will be sent to the pound
        name <- readline(prompt="Enter the dog's name ")
        
        dog_breed <- readline(prompt="Enter the dog's breed ")
        
        dog_sex <- readline(prompt="Enter the dog's sex ")
        
        dog_owner <- "This Dog is Ownerless"
        
        owner_phone <- "514-Dog-Pound"
        
        new_number <- max(MtlDogs$license_number) + 1
        
        newrecord <- data.frame(dog_name = name, license_number = new_number, 
                                breed = dog_breed, sex = dog_sex, owner = dog_owner,
                                phone = owner_phone, criminal_record = c(T))
        
        MtlDogs <- rbind(MtlDogs,newrecord)
        
       break
        
        #same if condition as above, except checking for if bitten is False
      } else if(DogNum > MtlDogs[nrow(MtlDogs),2] & ifBitten == F){
        
        name <- readline(prompt="Enter the dog's name ")
        
        dog_breed <- readline(prompt="Enter the dog's breed ")
        
        dog_sex <- readline(prompt="Enter the dog's sex ")
        
        dog_owner <- "This Dog is Ownerless"
        
        owner_phone <- "514-Dog-Pound"
        
        new_number <- max(MtlDogs$license_number) + 1
        
        newrecord <- data.frame(dog_name = name, license_number = new_number, 
                                breed = dog_breed, sex = dog_sex, owner = dog_owner,
                                phone = owner_phone, criminal_record = c(F))
        
       MtlDogs <- rbind(MtlDogs,newrecord)
        
        break
       
       #another error detection, this time looking whether the liscence number
       #is a negative number
      }else if(DogNum < 0 & ifBitten == T){
        
        name <- readline(prompt="Enter the dog's name ")
        
        dog_breed <- readline(prompt="Enter the dog's breed ")
        
        dog_sex <- readline(prompt="Enter the dog's sex ")
        
        dog_owner <- "This Dog is Ownerless"
        
        owner_phone <- "514-Dog-Pound"
        
        new_number <- max(MtlDogs$license_number) + 1
        
        newrecord <- data.frame(dog_name = name, license_number = new_number, 
                                breed = dog_breed, sex = dog_sex, owner = dog_owner,
                                phone = owner_phone, criminal_record = c(T))
        
        MtlDogs <- rbind(MtlDogs,newrecord)
        
        break
        
        
        #same as the one above but check if bitten is False
      }else if(DogNum < 0 & ifBitten == F){
        
        name <- readline(prompt="Enter the dog's name ")
        
        dog_breed <- readline(prompt="Enter the dog's breed ")
        
        dog_sex <- readline(prompt="Enter the dog's sex ")
        
        dog_owner <- "This Dog is Ownerless"
        
        owner_phone <- "514-Dog-Pound"
        
        new_number <- max(MtlDogs$license_number) + 1
        
        newrecord <- data.frame(dog_name = name, license_number = new_number, 
                                breed = dog_breed, sex = dog_sex, owner = dog_owner,
                                phone = owner_phone, criminal_record = c(F))
        
        MtlDogs <- rbind(MtlDogs,newrecord)
        
        break
  
      }
    
  }
  #only at the end of the for loop, do we return the updated
  #data.frame. Other wise it may corrupt the data
return(MtlDogs)
  }


Delete_a_license<-function(licenseNum){
 
  #a simple for loop going through the rows
   for (r in 1:nrow(MtlDogs)){
     
     #if the liscence number inputed by the user is equal to
     #the liscence number in the 2nd column of the data.frame
    if (licenseNum == MtlDogs[r,2]){
      
      #Then the dataframe returns with that column removed
      #Need to be certain to put the EXACT
      #liscence number or an error can occur
      #deleting the entire dataframe.
      return(MtlDogs<-MtlDogs[-r,])
    }
   }

}

Report_crime<-function(Ownername, Dogname){
 #report crime tries somewhat to correct for errors
  #stringr is imported to use the str_replace_all and the str_to_lower
  #functions
   library(stringr)
  for (r in 1:nrow(MtlDogs)){
    
    #going through the loop still by rows, if the name entered
    #by the user matches the name in column 5 (for the owners)
    #AND the Dog name entered matches the name in column 1
    
    #note that the str_replace_all removes spaces that can be put in error
    #and that str_to_lower checks brings both names to lower case in order to make 
    #sure that they are truly equal, less a capital letter 
    #would mess that up
    
    #note that both owner names and dog names still need to be
    #perfectly spelled, but you may include capital letter randomly 
    #as well as spaces and it ought to work
    if (str_replace_all(str_to_lower(Ownername)," ","") == str_replace_all(str_to_lower(MtlDogs[r,5])," ","") & 
        str_replace_all(str_to_lower(Dogname)," ","") == str_replace_all(str_to_lower(MtlDogs[r,1])," ","")){
      
      #if the condition is met, the 7th column for criminal records is 
      #changed to True
      MtlDogs[r,7]<-TRUE
      
    
    }
    
  }
  #return MtlDogs at the end to avoid returning empty dataframes
  return(MtlDogs)
  }



List_criminals<-function(){
 
  #one last for loop that goes through Montreal Dogs by row
   for (r in 1:nrow(MtlDogs)){
    #if the criminal record is True, thus a dog has bitten someone 
     if (MtlDogs[r,7]==TRUE){
    
       #then all the information is printed and pasted in order to space
       #the information out.
      print(paste(MtlDogs[r,1], MtlDogs[r,2], 
         MtlDogs[r,3],  MtlDogs[r,4],  MtlDogs[r,5],  
         MtlDogs[r,6]))
    }
  }
}

#This is the start of the shell where the user enters if he wishes to go into the loop
start_program<-readline("Would you like to start the program? Enter Y to start or N to quit: ")
while(start_program == "Y"){
  
  #depending on the function choise presented here
  function_choice<-as.integer(readline("Choose from the following options: 
                                       1.Issue a license for a dog  
                                       2.Query the database 
                                       3.Delete a license 
                                       4.Report a dog crime  
                                       5.list the criminals
                                       6.Quit"))
  
  #there are a bunch of if statements that run
  if(function_choice == 1){
    
    #if 1 is inputed by the user, the issue function is called
    #upon
    MtlDogs<-Issue(MtlDogs)
    
  }else if(function_choice == 2){
    
    #if 2 is chosen, Query is called upon but requires
    #a Dog number and a mention of whether or not
    #a bite occured
    dognum<-as.integer(readline("Enter the dog number: "))
    
    ifbitten<-as.logical(readline("Enter T if bitten or F if not: "))
    
    MtlDogs<-Query(dognum,ifbitten)
  
  }else if(function_choice == 3){
    #If 3 is chosen, then Deleting a liscence requires a 
    #liscence by the user to be deleted
    
    Licensenum<-as.integer(readline("Enter the license number of the dog you wish to remove: "))
   
    MtlDogs<-Delete_a_license(Licensenum)
    
  }else if(function_choice == 4){
    
    #same logic as 2 and 3
    owner<-readline("Enter the Owner of the criminal's name: ")
    
    dogcriminal<-readline("Enter the name of the guilty dog having committed the crime of biting: ")
   
    MtlDogs<-Report_crime(owner,dogcriminal)
    
  }else if(function_choice == 5){
    #notice 5 does not need any user input like option 1
    List_criminals()
    
  }else if(function_choice == 6){
    #6 asks the user if he wants to quit, 
    #admitted;y he can type in any other letter or integer than
    #N to exit, even lower case y
    #but we are assuming the user is a perfect typist
    #normally we would have to use string manipluation functions
    #like the ones in stringr to test conditions
    
    start_program<-readline("Input N to quit, Y to continue: ")
    #before the program ends, a new version
    #of Montreal dogs is created
    #Called NeoMontrealDogs because it sounds futuristic and cool
    write.csv(MtlDogs, "NeoMontrealDogs.csv")
    }
}
