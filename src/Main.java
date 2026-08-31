//enum

public class Main {
    public static void main(String[] args) {
        System.out.println(PaymentStatus.SUCCESS.toString());
        System.out.println(PaymentStatus.SUCCESS.getMessage());
        PaymentStatus a=PaymentStatus.FAILED;
        System.out.println(a.isSuccessfull());
        System.out.println(a.getCode());
        PaymentStatus b = PaymentStatus.getStatus(400);
        System.out.println(b);
    }
}

enum PaymentStatus {
    SUCCESS(200){
        @Override
        String getMessage(){
            return "Payment successfull";
        }
    },
    PENDING(300){
        @Override
        String getMessage(){
            return "Payment is being processes";
        }
    },
    FAILED(400){
        @Override
        String getMessage(){
            return "Payment failed";
        }
    };

    private final int statusCode;

    private PaymentStatus(int statusCode) {
        this.statusCode=statusCode;
    }

    int getCode(){
        return this.statusCode;
    }

    boolean isSuccessfull(){
        return this==SUCCESS;
    }

    @Override
    public String toString() {
        return this.name()+"(gg"+this.statusCode+")";
    }

    static PaymentStatus getStatus(int code){
        for(PaymentStatus p: PaymentStatus.values()){
            System.out.println(p);
            if(p.statusCode==code) return p;
        }
        return null;
    }

    abstract String getMessage();
}