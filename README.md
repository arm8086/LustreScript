# LustreScript
A statically typed transpiler written in Kotlin.
This language takes a JavaScript like syntax, with some Lua features and translates it to C.
# Sample
```
use "kerneltools.h"
var x = 5
function f() {
    return "Function!"
}
kprint("This will become bootable")
```
```
use <stdio.h>
printf("Hi!\n")
```
Semicolons are added if there aren't any
"use" gets replaced by "#include"
<> is used if the library is in C
"" is used if the library is part of LS
