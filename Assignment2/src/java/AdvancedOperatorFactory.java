public class AdvancedOperatorFactory extends BasicOperatorFactory {

    @Override
    public Operator getOperator(String symbol) {
        if(symbol == null){
            return null;
        }
        if(symbol.contentEquals("^")){
            return new ExponentOperator();
        }
        else {
            return super.getOperator(symbol);
        }
    }

    @Override
    public boolean supports(String symbol) {
        if(symbol == null){
            return false;
        }
        if (symbol.contentEquals("^")) {
            return true;

        }
        else return super.supports(symbol);
    }
}
