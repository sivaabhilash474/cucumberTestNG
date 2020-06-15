import numpy as np
import pandas as pd


print("Goodbye, World!")


df1 = pd.read_csv("C:\\source\\bookmonth1.csv")

print(df1.shape)

print(df1.dtypes)

print(df1)

df1['In_base'] = df1['In_base'].astype(str)
print("*" *100)
print(df1.info())
print("*" *100)
print(df1.astype(str)['In_base'].map(lambda x:  type(x)))



df1['Flag_check'] = np.where(((df1.In_base=='Y') & (df1.MI_company == "abc")) | ((df1.In_base == "N") & (df1.MI_company == "def")),"True","False")


#df1['Principle_Balance'] = df1['Principle_Balance'].round(4)
print(df1)

#df1[df1.dtypes=='float'].round(4)

#df1 = np.where(df1.select_dtypes(include=[np.float]),round(4))



#np.where(df1.dtypes==float,round(4),df1.dtypes)
#df1[df1.select_dtypes(['float'])] = df1[df1.select_dtypes(['float'])].round(4)

#print(df1[df1.select_dtypes(['float']).list()].round(4))

mylist = list(df1.select_dtypes(include=['float']).columns)  #Selecting all float columns 

print(mylist)

print(df1)
df1[mylist] = df1[mylist].round(4)   #applying roundoff on all float columns





print(df1)
print(mylist[0])