package com.suresh.businessrules.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AsBusinessRules")
public class BusinessRulesEntity {

   @Id
   private String            businessRuleGuid;
   private String            companyGuid;
   private String            productGuid;
   private String            planGuid;
   private String            fundGuid;
   private String            transactionGuid;
   private String            stateCode;
   private String            systemCode;
   private String            clientGuid;
   private String            policyGuid;
   private String            segmentGuid;
   private String            activityGuid;
   private String            requirementDefinitionGuid;
   private String            ruleName;
   private String            typeCode;
   private String            longName;
   private String            keywords;
   private String            comments;
   private String            errorNumber;
   private String            xmlData;
   private String            xmlSchema;
   private String            jsonSchema;
   private String            clientNumber;
   private String            programDefinitionGuid;
   private transient Integer hashCode;

   public BusinessRulesEntity() {

      hashCode = Integer.MIN_VALUE;
   }

   public String getBusinessRuleGuid() {

      return businessRuleGuid;
   }

   public void setBusinessRuleGuid( String businessRuleGuid ) {

      this.businessRuleGuid = businessRuleGuid;
   }

   public String getCompanyGuid() {

      return companyGuid;
   }

   public void setCompanyGuid( String companyGuid ) {

      this.companyGuid = companyGuid;
   }

   public String getProductGuid() {

      return productGuid;
   }

   public void setProductGuid( String productGuid ) {

      this.productGuid = productGuid;
   }

   public String getPlanGuid() {

      return planGuid;
   }

   public void setPlanGuid( String planGuid ) {

      this.planGuid = planGuid;
   }

   public String getFundGuid() {

      return fundGuid;
   }

   public void setFundGuid( String fundGuid ) {

      this.fundGuid = fundGuid;
   }

   public String getTransactionGuid() {

      return transactionGuid;
   }

   public void setTransactionGuid( String transactionGuid ) {

      this.transactionGuid = transactionGuid;
   }

   public String getStateCode() {

      return stateCode;
   }

   public void setStateCode( String stateCode ) {

      this.stateCode = stateCode;
   }

   public String getSystemCode() {

      return systemCode;
   }

   public void setSystemCode( String systemCode ) {

      this.systemCode = systemCode;
   }

   public String getClientGuid() {

      return clientGuid;
   }

   public void setClientGuid( String clientGuid ) {

      this.clientGuid = clientGuid;
   }

   public String getPolicyGuid() {

      return policyGuid;
   }

   public void setPolicyGuid( String policyGuid ) {

      this.policyGuid = policyGuid;
   }

   public String getSegmentGuid() {

      return segmentGuid;
   }

   public void setSegmentGuid( String segmentGuid ) {

      this.segmentGuid = segmentGuid;
   }

   public String getActivityGuid() {

      return activityGuid;
   }

   public void setActivityGuid( String activityGuid ) {

      this.activityGuid = activityGuid;
   }

   public String getRequirementDefinitionGuid() {

      return requirementDefinitionGuid;
   }

   public void setRequirementDefinitionGuid( String requirementDefinitionGuid ) {

      this.requirementDefinitionGuid = requirementDefinitionGuid;
   }

   public String getRuleName() {

      return ruleName;
   }

   public void setRuleName( String ruleName ) {

      this.ruleName = ruleName;
   }

   public String getTypeCode() {

      return typeCode;
   }

   public void setTypeCode( String typeCode ) {

      this.typeCode = typeCode;
   }

   public String getLongName() {

      return longName;
   }

   public void setLongName( String longName ) {

      this.longName = longName;
   }

   public String getKeywords() {

      return keywords;
   }

   public void setKeywords( String keywords ) {

      this.keywords = keywords;
   }

   public String getComments() {

      return comments;
   }

   public void setComments( String comments ) {

      this.comments = comments;
   }

   public String getErrorNumber() {

      return errorNumber;
   }

   public void setErrorNumber( String errorNumber ) {

      this.errorNumber = errorNumber;
   }

   public String getXmlData() {

      return xmlData;
   }

   public void setXmlData( String xmlData ) {

      this.xmlData = xmlData;
   }

   public String getXmlSchema() {

      return xmlSchema;
   }

   public void setXmlSchema( String xmlSchema ) {

      this.xmlSchema = xmlSchema;
   }

   public String getJsonSchema() {

      return jsonSchema;
   }

   public void setJsonSchema( String jsonSchema ) {

      this.jsonSchema = jsonSchema;
   }

   public String getClientNumber() {

      return clientNumber;
   }

   public void setClientNumber( String clientNumber ) {

      this.clientNumber = clientNumber;
   }

   public String getProgramDefinitionGuid() {

      return programDefinitionGuid;
   }

   public void setProgramDefinitionGuid( String programDefinitionGuid ) {

      this.programDefinitionGuid = programDefinitionGuid;
   }

   @Override
   public int hashCode() {

      if( Integer.MIN_VALUE == this.hashCode ) {
         if( null == this.getBusinessRuleGuid() ) {
            return super.hashCode();
         }
         else {
            String hashStr = this.getClass().getName() + ":" + this.getBusinessRuleGuid().hashCode();
            this.hashCode = hashStr.hashCode();
         }
      }
      return this.hashCode;
   }

   @Override
   public boolean equals( Object obj ) {

      if( this == obj )
         return true;
      if( obj == null )
         return false;
      if( getClass() != obj.getClass() )
         return false;
      BusinessRulesEntity other = ( BusinessRulesEntity )obj;
      if( businessRuleGuid == null ) {
         if( other.businessRuleGuid != null )
            return false;
      }
      else if( !businessRuleGuid.equals( other.businessRuleGuid ) )
         return false;
      return true;
   }

   @Override
   public String toString() {

      return "BusinessRules [businessRuleGuid=" + businessRuleGuid + ", companyGuid=" + companyGuid + ", productGuid=" + productGuid + ", planGuid=" + planGuid + ", fundGuid=" + fundGuid + ", transactionGuid=" + transactionGuid + ", stateCode=" + stateCode + ", systemCode=" + systemCode + ", clientGuid=" + clientGuid + ", policyGuid=" + policyGuid + ", segmentGuid=" + segmentGuid + ", activityGuid=" + activityGuid + ", requirementDefinitionGuid=" + requirementDefinitionGuid + ", ruleName=" + ruleName + ", typeCode=" + typeCode + ", longName=" + longName + ", keywords=" + keywords + ", comments=" + comments + ", errorNumber=" + errorNumber + ", xmlData=" + xmlData + ", xmlSchema=" + xmlSchema + ", jsonSchema=" + jsonSchema + ", clientNumber=" + clientNumber + ", programDefinitionGuid=" + programDefinitionGuid + "]";
   }
}
