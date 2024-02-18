virtualpet.class: virtualpet.class
		javac -g virtualpet.java

clean:
	rm -f *.class
	rm -f *.ser

run: virtualpet.class
	java virtualpet 
