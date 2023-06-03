package com.example.listapp.model;

public class Container {
   private int imageId;
   private String title;
   private String description;

   public Container(int imageId , String title , String description){
      this.imageId = imageId;
      this.title = title;
      this.description = description;

   }

   public int getImageId() {
      return imageId;
   }

   public void setImageId(int imageId) {
      this.imageId = imageId;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }


}
