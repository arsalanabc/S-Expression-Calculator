#S-Expression Calculator

This is a simple calculator that takes an expression through command line argument.

An expression can one of the following:
 - atomic integer i.e. 0, 1, 123 etc 
 - (OPERAND EXP EXP)
    - OPERAND = "add" | "multiply"
    - EXP = atomic integer | (OPERAND EXP EXP)
 
For example here are some valid sample arguments to pass
- 0
- -123 
- (add 1 2)
- (multiply 1 (add 1 (multiply 1 2)))
 
###Project components
###Calculator:
Provides logic for addition and multiplication on integers
###StringParser:
Tokenizes the input by adding spaces around the brackets, replacing "add" and "multiply" 
with + and * respectively, and lastly splitting by spaces.
i.e. (add 1 2) => ["(", "+", "1", "2", ")"] 
###CalculatorApp:
Acts like a bridge between StringParser and Calculator. It passes the user argument
to StringParser which returns a tokenized string. CalculatorApp converts the tokenized 
string into a Tree. Finally, it traverses the tree, evaluating nodes recursively with 
Calculator.
CalculatorApp also defines rules for mapping signs to keywords, brackets and brackets spacing to
maintain integrity for StringParser and Calculator contract.

### To update or add a new operation to Calculator
1. Implement `Operation` interface i.e `Division`
2.  Create a operator sign i.e "/"
3. pass the sign and the new operation to `Calculator` with `addOrUpdateOperation`
4. update `wordToSign_map` in `CalculatorApp`



  
