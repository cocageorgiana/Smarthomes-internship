import random

file = open('numbers.txt', 'w')

myArray = []
myArray = random.sample(range(1, 100), 10)

print(', '.join(map(str, myArray)))

for it in myArray:
	file.write("%s\n" % it)