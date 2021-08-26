public class BasicOperatorFactory extends OperatorFactory {
    @Override
    public Operator getOperator(String symbol)  {
        if(symbol == null){
            return null;
        }
        if(symbol.contentEquals("+")){
            return new AdditionOperator();
        }
        else if(symbol.contentEquals("-")){
            return new SubtractionOperator();
        }
        else if(symbol.contentEquals("/")){
            return new DivisionOperator();
        }
        else if(symbol.contentEquals("*")){
            return new MultiplicationOperator();
        }
        else {
            return null;
        }
    }

    @Override
    public boolean supports(String symbol) {
        if(symbol == null){
            return false;
        }
        if(symbol.contentEquals("+")){
            return true;
        }
        else if(symbol.contentEquals("-")){
            return true;
        }
        else if(symbol.contentEquals("/")){
            return true;
        }
        else if(symbol.contentEquals("*")){
            return true;
        }

        return false;
    }
}
