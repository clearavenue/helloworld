package com.clearavenue.helloworld.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@SuppressFBWarnings(value = { "EI_EXPOSE_REP", "EI_EXPOSE_REP2" }, justification = "We can modify dates")
public class InpatientClaims {

	@CsvBindByName(column = "DESYNPUF_ID")
	private String desynpufId;

	@CsvBindByName(column = "CLM_ID")
	private String claimId;

	@CsvBindByName(column = "SEGMENT")
	private int segment;

	@CsvBindByName(column = "CLM_FROM_DT")
	@CsvDate("yyyyMMdd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date claimFromDate;

	@CsvBindByName(column = "CLM_THRU_DT")
	@CsvDate("yyyyMMdd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date claimThruDate;

	@CsvBindByName(column = "PRVDR_NUM")
	private String providerNum;

	@CsvBindByName(column = "CLM_PMT_AMT")
	private Double claimPaymentAmt;

	@CsvBindByName(column = "NCH_PRMRY_PYR_CLM_PD_AMT")
	private Double nchPrimaryPayerClaimPdAmt;

	@CsvBindByName(column = "OP_PHYSN_NPI")
	private String opPhysicianNPI;

	@CsvBindByName(column = "OT_PHYSN_NPI")
	private String otPhysicianNPI;

	@CsvBindByName(column = "CLM_ADMSN_DT")
	@CsvDate("yyyyMMdd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date claimsAdmissionDate;

	@CsvBindByName(column = "ADMTNG_ICD9_DGNS_CD")
	private String admittingIcd9DgnsCode;

	@CsvBindByName(column = "CLM_PASS_THRU_PER_DIEM_AMT")
	private Double claimsPassThruPerDiemAmt;

	@CsvBindByName(column = "NCH_BENE_IP_DDCTBL_AMT")
	private Double nchBeneIpDeductAmt;

	@CsvBindByName(column = "NCH_BENE_PTA_COINSRNC_LBLTY_AM")
	private Double nchBenePtaCoinsLiabilityAmt;

	@CsvBindByName(column = "NCH_BENE_BLOOD_DDCTBL_LBLTY_AM")
	private Double nchBeneBloodDeductLiabilityAmt;

	@CsvBindByName(column = "CLM_UTLZTN_DAY_CNT")
	private int claimUtilizationDayCount;

	@CsvBindByName(column = "NCH_BENE_DSCHRG_DT")
	@CsvDate("yyyyMMdd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date nchBeneDischargeDate;

	@CsvBindByName(column = "CLM_DRG_CD")
	private String claimDrgCode;

	@CsvBindByName(column = "ICD9_DGNS_CD_1")
	private String icd9DgnsCode1;

	@CsvBindByName(column = "ICD9_DGNS_CD_2")
	private String icd9DgnsCode2;

	@CsvBindByName(column = "ICD9_DGNS_CD_3")
	private String icd9DgnsCode3;

	@CsvBindByName(column = "ICD9_DGNS_CD_4")
	private String icd9DgnsCode4;

	@CsvBindByName(column = "ICD9_DGNS_CD_5")
	private String icd9DgnsCode5;

	@CsvBindByName(column = "ICD9_DGNS_CD_6")
	private String icd9DgnsCode6;

	@CsvBindByName(column = "ICD9_DGNS_CD_7")
	private String icd9DgnsCode7;

	@CsvBindByName(column = "ICD9_DGNS_CD_8")
	private String icd9DgnsCode8;

	@CsvBindByName(column = "ICD9_DGNS_CD_9")
	private String icd9DgnsCode9;

	@CsvBindByName(column = "ICD9_DGNS_CD_10")
	private String icd9DgnsCode10;

	@CsvBindByName(column = "ICD9_PRCDR_CD_1")
	private String icd9PrcdrCode1;

	@CsvBindByName(column = "ICD9_PRCDRS_CD_2")
	private String icd9PrcdrCode2;

	@CsvBindByName(column = "ICD9_PRCDRS_CD_3")
	private String icd9PrcdrCode3;

	@CsvBindByName(column = "ICD9_PRCDR_CD_4")
	private String icd9PrcdrCode4;

	@CsvBindByName(column = "ICD9_PRCDRS_CD_5")
	private String icd9PrcdrCode5;

	@CsvBindByName(column = "ICD9_PRCDRS_CD_6")
	private String icd9PrcdrCode6;

	@CsvBindByName(column = "HCPCS_CD_1")
	private String hcpcsCode1;

	@CsvBindByName(column = "HCPCS_CD_2")
	private String hcpcsCode2;

	@CsvBindByName(column = "HCPCS_CD_3")
	private String hcpcsCode3;

	@CsvBindByName(column = "HCPCS_CD_4")
	private String hcpcsCode4;

	@CsvBindByName(column = "HCPCS_CD_5")
	private String hcpcsCode5;

	@CsvBindByName(column = "HCPCS_CD_6")
	private String hcpcsCode6;

	@CsvBindByName(column = "HCPCS_CD_7")
	private String hcpcsCode7;

	@CsvBindByName(column = "HCPCS_CD_8")
	private String hcpcsCode8;

	@CsvBindByName(column = "HCPCS_CD_9")
	private String hcpcsCode9;

	@CsvBindByName(column = "HCPCS_CD_10")
	private String hcpcsCode10;

	@CsvBindByName(column = "HCPCS_CD_11")
	private String hcpcsCode11;

	@CsvBindByName(column = "HCPCS_CD_12")
	private String hcpcsCode12;

	@CsvBindByName(column = "HCPCS_CD_13")
	private String hcpcsCode13;

	@CsvBindByName(column = "HCPCS_CD_14")
	private String hcpcsCode14;

	@CsvBindByName(column = "HCPCS_CD_15")
	private String hcpcsCode15;

	@CsvBindByName(column = "HCPCS_CD_16")
	private String hcpcsCode16;

	@CsvBindByName(column = "HCPCS_CD_17")
	private String hcpcsCode17;

	@CsvBindByName(column = "HCPCS_CD_18")
	private String hcpcsCode18;

	@CsvBindByName(column = "HCPCS_CD_19")
	private String hcpcsCode19;

	@CsvBindByName(column = "HCPCS_CD_20")
	private String hcpcsCode20;

	@CsvBindByName(column = "HCPCS_CD_21")
	private String hcpcsCode21;

	@CsvBindByName(column = "HCPCS_CD_22")
	private String hcpcsCode22;

	@CsvBindByName(column = "HCPCS_CD_23")
	private String hcpcsCode23;

	@CsvBindByName(column = "HCPCS_CD_24")
	private String hcpcsCode24;

	@CsvBindByName(column = "HCPCS_CD_25")
	private String hcpcsCode25;

	@CsvBindByName(column = "HCPCS_CD_26")
	private String hcpcsCode26;

	@CsvBindByName(column = "HCPCS_CD_27")
	private String hcpcsCode27;

	@CsvBindByName(column = "HCPCS_CD_28")
	private String hcpcsCode28;

	@CsvBindByName(column = "HCPCS_CD_29")
	private String hcpcsCode29;

	@CsvBindByName(column = "HCPCS_CD_30")
	private String hcpcsCode30;

	@CsvBindByName(column = "HCPCS_CD_31")
	private String hcpcsCode31;

	@CsvBindByName(column = "HCPCS_CD_32")
	private String hcpcsCode32;

	@CsvBindByName(column = "HCPCS_CD_33")
	private String hcpcsCode33;

	@CsvBindByName(column = "HCPCS_CD_34")
	private String hcpcsCode34;

	@CsvBindByName(column = "HCPCS_CD_35")
	private String hcpcsCode35;

	@CsvBindByName(column = "HCPCS_CD_36")
	private String hcpcsCode36;

	@CsvBindByName(column = "HCPCS_CD_37")
	private String hcpcsCode37;

	@CsvBindByName(column = "HCPCS_CD_38")
	private String hcpcsCode38;

	@CsvBindByName(column = "HCPCS_CD_39")
	private String hcpcsCode39;

	@CsvBindByName(column = "HCPCS_CD_40")
	private String hcpcsCode40;

	@CsvBindByName(column = "HCPCS_CD_41")
	private String hcpcsCode41;

	@CsvBindByName(column = "HCPCS_CD_42")
	private String hcpcsCode42;

	@CsvBindByName(column = "HCPCS_CD_43")
	private String hcpcsCode43;

	@CsvBindByName(column = "HCPCS_CD_44")
	private String hcpcsCode44;

	@CsvBindByName(column = "HCPCS_CD_45")
	private String hcpcsCode45;

}
