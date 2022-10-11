.DEFAULT_GOAL := standard

standard:
	javac src/*.java -d bin
	
clean: 
	rm bin/*

all: clean standard