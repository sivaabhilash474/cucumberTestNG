import numpy as np
import pandas as pd
import sys


seperator=","
#python DataFramesComparsion.py "," "sourcefilepath" "targetfilepath" "roundoff"

#python DataFramesComparsion.py "," "C:\\source\\1000000 Sales Records.csv" "C:\\target\\1000000 Sales Records.csv" 2

#python DataFramesComparsion.py , C:\\source\\1000000_Sales_Records.csv C:\\target\\1000000_Sales_Records.csv 2

#python DataFramesComparsion.py , C:\\source\\bookmonth1.csv C:\\target\\bookmonth1_target.csv 2

seperator= sys.argv[1]
sourceFile = sys.argv[2]
targetFile = sys.argv[3]
roundoff = int(sys.argv[4])

print(type(roundoff))

print("*" * 100)
print("Seperator passed from the command line: ", seperator)
print("*" * 100)

df1=pd.read_csv(sourceFile, sep=seperator)
df2=pd.read_csv(targetFile, sep=seperator)

print(df1.dtypes)
print(df1.dtypes)

df1.replace(np.nan, 0, inplace=True)
df2.replace(np.nan, 0, inplace=True)

mylist1 = list(df1.select_dtypes(include=['float']).columns)
df1[mylist1] = df1[mylist1].round(roundoff)

mylist2 = list(df2.select_dtypes(include=['float']).columns)
df2[mylist2] = df2[mylist2].round(roundoff)

comparison_values = df1.values == df2.values
print(comparison_values)


rows,cols=np.where(comparison_values==False)

print("*" * 100)
print(rows)
print(cols)
print("*" * 100)


print(np.size(comparison_values) - np.count_nonzero(comparison_values))

number_of_differences = np.size(comparison_values) - np.count_nonzero(comparison_values)

if(number_of_differences > 0):
    print("Number of Differences: ",number_of_differences)
    
    
for item in zip(rows,cols):
    df1.iloc[item[0], item[1]] = 'Source:{} --> Target:{}'.format(df1.iloc[item[0], item[1]],df2.iloc[item[0], item[1]])
    
    
print(df1)


df1.to_excel('C:\\results\\Excel_diff.xlsx',index=False,header=True)

if(number_of_differences > 0):
    print(number_of_differences)