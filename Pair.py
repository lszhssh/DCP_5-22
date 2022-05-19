# what's f in this situation? - just a placeholder, I think, to signify that we 
# want an argument in there

# I'm still confused on how exactly to utilize lambdas (I think they function in
# a similar way in Java) and what the benefits are

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair

def car(pair):
    return pair(lambda a, b: a)

def cdr(pair):
    return pair(lambda a, b: b)

print(car(cons(3, 4)))
print(cdr(cons(3, 4)))