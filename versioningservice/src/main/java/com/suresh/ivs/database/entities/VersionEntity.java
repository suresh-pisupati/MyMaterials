package com.suresh.ivs.database.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "IVSVersion")
public class VersionEntity {

   @Id
   private String            versionGuid;
   private String            ruleGuid;
   private int               versionNumber;
   private String            ruleTypeCode;
   @Temporal(TemporalType.TIMESTAMP)
   private Date              lastModifiedGmt;
   private String            lastModifiedBy;
   private String            comments;
   private String            label;
   private transient Integer hashCode;

   public VersionEntity() {

      hashCode = Integer.MIN_VALUE;
   }

   /**
    * @return the versionGuid
    */
   public String getVersionGuid() {

      return versionGuid;
   }

   /**
    * @param versionGuid
    *           the versionGuid to set
    */
   public void setVersionGuid( String versionGuid ) {

      this.versionGuid = versionGuid;
   }

   /**
    * @return the ruleGuid
    */
   public String getRuleGuid() {

      return ruleGuid;
   }

   /**
    * @param ruleGuid
    *           the ruleGuid to set
    */
   public void setRuleGuid( String ruleGuid ) {

      this.ruleGuid = ruleGuid;
   }

   /**
    * @return the versionNumber
    */
   public int getVersionNumber() {

      return versionNumber;
   }

   /**
    * @param versionNumber
    *           the versionNumber to set
    */
   public void setVersionNumber( int versionNumber ) {

      this.versionNumber = versionNumber;
   }

   /**
    * @return the ruleTypeCode
    */
   public String getRuleTypeCode() {

      return ruleTypeCode;
   }

   /**
    * @param ruleTypeCode
    *           the ruleTypeCode to set
    */
   public void setRuleTypeCode( String ruleTypeCode ) {

      this.ruleTypeCode = ruleTypeCode;
   }

   /**
    * @return the lastModifiedGmt
    */
   public Date getLastModifiedGmt() {

      return lastModifiedGmt;
   }

   /**
    * @param lastModifiedGmt
    *           the lastModifiedGmt to set
    */
   public void setLastModifiedGmt( Date lastModifiedGmt ) {

      this.lastModifiedGmt = lastModifiedGmt;
   }

   /**
    * @return the lastModifiedBy
    */
   public String getLastModifiedBy() {

      return lastModifiedBy;
   }

   /**
    * @param lastModifiedBy
    *           the lastModifiedBy to set
    */
   public void setLastModifiedBy( String lastModifiedBy ) {

      this.lastModifiedBy = lastModifiedBy;
   }

   /**
    * @return the comments
    */
   public String getComments() {

      return comments;
   }

   /**
    * @param comments
    *           the comments to set
    */
   public void setComments( String comments ) {

      this.comments = comments;
   }

   /**
    * @return the label
    */
   public String getLabel() {

      return label;
   }

   /**
    * @param label
    *           the label to set
    */
   public void setLabel( String label ) {

      this.label = label;
   }

   @Override
   public boolean equals( Object object ) {

      if( null == object ) {
         return false;
      }
      if( !( object instanceof VersionEntity ) ) {
         return false;
      }
      else {
         VersionEntity versionEntity = ( VersionEntity )object;
         if( null == this.getVersionGuid() || null == versionEntity.getVersionGuid() ) {
            return false;
         }
         else {
            return ( this.getVersionGuid().equals( versionEntity.getVersionGuid() ) );
         }
      }
   }

   /*
    * (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {

      if( Integer.MIN_VALUE == this.hashCode ) {
         if( null == this.getVersionGuid() ) {
            return super.hashCode();
         }
         else {
            String hashStr = this.getClass().getName() + ":" + this.getVersionGuid().hashCode();
            this.hashCode = hashStr.hashCode();
         }
      }
      return this.hashCode;
   }
}
