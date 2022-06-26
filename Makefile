SRC = lustre.kt
OUT = lustreScript.jar
ARG = -include-runtime -d

build:
	kotlinc $(SRC) $(ARG) $(OUT)