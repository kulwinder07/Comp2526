public class Calculator {
    OperatorFactory operatorFactory;

    public Calculator(BasicOperatorFactory basicOperatorFactory)
    {
        operatorFactory = basicOperatorFactory;
    }

    public Calculator() throws UnknownOperatorFactoryException
    {
        operatorFactory = OperatorFactoryGenerator.createOperatorFactory(OperatorFactoryType.BASIC);
    }

    public Calculator(OperatorFactory operatorFactoryB)
    {

        operatorFactory = operatorFactoryB;
    }

    public boolean supportsOperator(String symbol)
    {
        return operatorFactory.supports(symbol);
    }

    public int calculate(int a, String symbol, int b) {
        Operator operator=  operatorFactory.getOperator(symbol);
        if(operator == null) {
            throw new UnsupportedOperatorException(symbol);
        }
        return operator.perform(a, b);
    }
}
