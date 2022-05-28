$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' '-Dfile.encoding=UTF-8' -cp '.;../lib/routines.jar;../lib/log4j-slf4j-impl-2.12.1.jar;../lib/log4j-api-2.12.1.jar;../lib/log4j-core-2.12.1.jar;../lib/log4j-1.2-api-2.12.1.jar;../lib/commons-collections-3.2.2.jar;../lib/jboss-serialization.jar;../lib/advancedPersistentLookupLib-1.2.jar;../lib/slf4j-api-1.7.25.jar;../lib/dom4j-2.1.1.jar;../lib/tdgssconfig-16.20.00.02.jar;../lib/terajdbc4-16.20.00.02.jar;../lib/trove.jar;../lib/crypto-utils.jar;etl_pipeline_stg_ldr_0_1.jar;accounts_stg_to_ldr_0_1.jar;address_stg_to_ldr_0_1.jar;bank_stg_to_ldr_0_1.jar;transaction_stg_to_ldr_0_1.jar;contact_stg_to_ldr_0_1.jar;branch_stg_to_ldr_0_1.jar;' demo_staging_finance.etl_pipeline_stg_ldr_0_1.ETL_Pipeline_STG_LDR  $args