package com.suresh.paletteconfig.exception;

public class PropertyFileNotFoundException extends RuntimeException {

   private static final long serialVersionUID = 1L;

   private String            message;

   public PropertyFileNotFoundException() {

   }

   public PropertyFileNotFoundException( String message ) {

      this.message = message;
   }

   @Override
   public String toString() {

      return message;
   }
}
