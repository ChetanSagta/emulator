package nes.exceptions;

public class InvalidMemoryRangeException extends Exception{

  public InvalidMemoryRangeException(){
    super();
  }

  public InvalidMemoryRangeException(String message){
    super(message);
  }


}
