# Project3
For project 3 I began with a constructor Method, which gets seconds at the time the Program runs using the java.util.LocalDateTime. The dateTimeNow() method then uses a DateTimeFormatter to return the date and time with the following format: "MM/dd/yyyy h:mm a". The sleepForFiveSec() method is called when the current second is greater than 55. If called, the system sleeps the run for 5 seconds. The method dateTimeOfOtherCity() calculates the current time in GMT, BST, and CST time zones. The time value is formatted "H:mm" and printed:\nTime on Server: 15:14 \n GMT: 20:14 \n BST (90E): 2:14 \n CST (90W): 15:14 I implemented the dateTImeDifferentZone() to store the values in a Hashmap. GMT, BST etc. are used as keys and time/date as values. The Hashmap key and value are of type String like HashMap<String, String> Outputs the String:
			GMT: 10/08/2019 20:26
			BST: 10/09/2019 02:26
			CST: 10/08/2019 15:26

After this, timeZoneHashMap() adds in two new time zones, AST and ZST with their date/time values into the HashMap. It uses tree maps to sort the Hashmaps in the following way:
	 		Print Style 1:
			AST 10/01/2020 19:59
			BST 10/09/2019 02:48
			CST 10/08/2019 15:48
			GMT 10/08/2019 20:48
			ZST 11/05/2018 19:59
			Print Style 3:
			10/01/2020 19:59
			10/08/2019 15:48
			10/08/2019 20:48
			10/09/2019 02:48
			11/05/2018 19:59
			Print Style 5: Final sorted Array:
			2020-10-01T19:59
			2019-10-09T02:48
			2019-10-08T20:48
			2019-10-08T15:48
		2018-11-05T19:59

The daysOfCurrentMonth() method calculates the specific week day given a day during the current month and prints: "The tenth day of this month is " + tenthDay + " and eighteenth is " + eighteenthtDay". Next, the DaysOfAnyMonth() method takes in two parameters, the first is month number and the second is year. It then calculates the 15th day of the given parameters. Output format is: “For the year (2019) and month (10), the fifteenth day is TUESDAY and the last day is THURSDAY”. The method compareYear() calls the read method to read in "Dates.txt". It uses an enhanced for loop to iterate through the dates seeing if it is a leap year and calculateing the time difference from the current date to the date read in. Prints in the format: "2017 is not a leap year, and Difference: 2 years, 5 months, and 3 days". 

Then, dateHashMap() uses an enhanced for loop to print the key and associated value of the LocalDatesMap HashMap. To sort this map, dateHashMapSorted() uses a treeMap and an enhanced for loop to print the sorted key and associated value of the LocalDatesMap HashMap. The read() method reads in a file, it use a formatter and parse method to convert the string to a LocalDate type and saves each value into the private HashMap LocalDatesMap.

To calculate the ascii average, the method calculates the Ascii average of the station name by creating an array of size 4, each element being the character casted to a double (Ascii Value). The asciiAvg is calculated by summing the elements of the AsciiVal array and dividing by 4. Assigns the value at index 0 to be the average rounded up, the value at index 1 to be the average rounded down, and the value at index 2 to be the average rounded up if >.5 or down if <.5.

In the MesoEquivelant class, the Constructor takes in the stId parameter to assign to stationID and calls the Read method to read in "Mesonet.txt". the CallAsciiEqual() method uses the value calculated from MesoAsciiCal and the array of stations from CalSameAsciiAvg() to create a HashMap (stationMap) which holds the stations with the same Ascii average as "NRMN" and the input value. After this, the dateHashMapSorted() method creates an array with the key values of the DatestoSortMap. Implements the insertion sorting method to sort the arrays in ascending order. Similar to the pervious method, dateHashMapSortedDescending() creates an array with the key values of the DatestoSortMap. Implements the insertion sorting method to sort the arrays in descending order. DateSortingUsingAlgorithm() calls the read method to read in "SortingDates.txt" to use the values in the given class.
