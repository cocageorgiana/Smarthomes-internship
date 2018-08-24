import random

myArray = []
myArray = random.sample(range(1, 10000), 10)

print(' '.join(map(str, myArray)))