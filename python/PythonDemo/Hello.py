filename=input("Enter FileName with Path  ")
try:
    obj = open(filename, "r")
    for i in obj:
        print(i)
except PermissionError:
    print("Sorry Drive No Permission")
except FileNotFoundError:
    print("File Not Found")
finally:
    print("Program By Zorin...")