-- Data is limited to a max of 5 entries per dtxsid or 10 entries total when no dtxsid is available
-- Seleted dtxsids are Bisphenol A (DTXSID7020182) and Atrazine (DTXSID9020112)

-- nhanes.biomonitor_data
INSERT INTO nhanes.biomonitor_data (dtxsid,demographic_group,intake_rate_mgpkgpday,low95,up95,nhanes_cohort,data_version,export_date) VALUES
	 ('DTXSID7020182','Total',0.000017293,0.000016691,0.000017903,'15-16',NULL,NULL),
	 ('DTXSID7020182','Male',0.000018757,0.000016888,0.000021005,'15-16',NULL,NULL),
	 ('DTXSID7020182','Female',0.000016025,0.000014924,0.000017202,'15-16',NULL,NULL),
	 ('DTXSID7020182','3 - 5 years',0.000063964,0.000051602,0.000079916,'15-16',NULL,NULL),
	 ('DTXSID7020182','6 - 11 years',0.000027678,0.000024398,0.000031685,'15-16',NULL,NULL),
	 ('DTXSID9020112','Total',0.000000058817,0.0000000020347,0.00000072122,'07-08',NULL,NULL),
	 ('DTXSID9020112','Male',0.000000048876,0.00000000059431,0.00000071182,'07-08',NULL,NULL),
	 ('DTXSID9020112','Female',0.000000075747,0.00000000307,0.00000084943,'07-08',NULL,NULL),
	 ('DTXSID9020112','6 - 11 years',0.0000000090157,0.000000000010476,0.0000005571,'07-08',NULL,NULL),
	 ('DTXSID9020112','12 - 19 years',0.0000000074846,0.0000000000086298,0.00000060682,'07-08',NULL,NULL);


-- chemexpo.mv_t_ccd_chemical_weight_fractions
INSERT INTO chemexpo.mv_t_ccd_chemical_weight_fractions (id,dtxsid,prod_name,display_puc,puc_kind,lower_weight_fraction,upper_weight_fraction,weight_fraction_type,gen_cat,prod_fam,prod_type,puc_definition,source_name,source_description,source_url,source_download_date,prod_count,data_version,export_date) VALUES
	 (1322889,'DTXSID7020182','concresive 1001 lpl part a','Not yet Categorized',NULL,NULL,NULL,'reported',NULL,NULL,NULL,NULL,'SIRI','Products found in the SIRI database, a compilation of Material Safety Data Sheets (MSDS). Note the database may no longer be maintained.','http://hazard.com/msds/index.php','2019-02-27',1,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (1322890,'DTXSID7020182','cr-180 hardener_ pt b','Not yet Categorized',NULL,0.010000000000000,1.000000000000000,'reported',NULL,NULL,NULL,NULL,'SIRI','Products found in the SIRI database, a compilation of Material Safety Data Sheets (MSDS). Note the database may no longer be maintained.','http://hazard.com/msds/index.php','2019-02-27',1,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (1322891,'DTXSID7020182','curing agent ta30-b','Not yet Categorized',NULL,NULL,NULL,'reported',NULL,NULL,NULL,NULL,'SIRI','Products found in the SIRI database, a compilation of Material Safety Data Sheets (MSDS). Note the database may no longer be maintained.','http://hazard.com/msds/index.php','2019-02-27',1,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (1322892,'DTXSID7020182','cw 1661 cronasphere hardener','Not yet Categorized',NULL,0.000000000000000,0.550000000000000,'reported',NULL,NULL,NULL,NULL,'SIRI','Products found in the SIRI database, a compilation of Material Safety Data Sheets (MSDS). Note the database may no longer be maintained.','http://hazard.com/msds/index.php','2019-02-27',1,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (1322893,'DTXSID7020182','cw1654 poly-cream-p hardener','Not yet Categorized',NULL,0.010000000000000,0.100000000000000,'reported',NULL,NULL,NULL,NULL,'SIRI','Products found in the SIRI database, a compilation of Material Safety Data Sheets (MSDS). Note the database may no longer be maintained.','http://hazard.com/msds/index.php','2019-02-27',1,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (1673201,'DTXSID9020112','atratol 80w','Raw materials:coatings','Occupation',NULL,NULL,'reported','Raw materials','coatings','','Coatings manufactured for commercial use.','SIRI','Products found in the SIRI database, a compilation of Material Safety Data Sheets (MSDS). Note the database may no longer be maintained.','http://hazard.com/msds/index.php','2019-02-27',1,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (1673202,'DTXSID9020112','atratol 8p','Raw materials:coatings','Occupation',NULL,NULL,'reported','Raw materials','coatings','','Coatings manufactured for commercial use.','SIRI','Products found in the SIRI database, a compilation of Material Safety Data Sheets (MSDS). Note the database may no longer be maintained.','http://hazard.com/msds/index.php','2019-02-27',1,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (1673203,'DTXSID9020112','atrazine 80w','Not yet Categorized',NULL,NULL,NULL,'reported',NULL,NULL,NULL,NULL,'SIRI','Products found in the SIRI database, a compilation of Material Safety Data Sheets (MSDS). Note the database may no longer be maintained.','http://hazard.com/msds/index.php','2019-02-27',1,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (1673204,'DTXSID9020112','atrazine technical','Raw materials:coatings','Occupation',NULL,NULL,'reported','Raw materials','coatings','','Coatings manufactured for commercial use.','SIRI','Products found in the SIRI database, a compilation of Material Safety Data Sheets (MSDS). Note the database may no longer be maintained.','http://hazard.com/msds/index.php','2019-02-27',1,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (1673205,'DTXSID9020112','f2208s 2-chloro-4-ethylamino-6-isopropylamino-s-triazine','Laboratory supplies','Occupation',NULL,NULL,'reported','Laboratory supplies','','','Products specifically used in a laboratory setting, e.g. laboratory diagnostics or consumables, solvents and reagents used in experiments or laboratory tests, etc. Includes supplies for medical testing. Note that pure chemicals will be included in the ''Raw materials'' category.','SIRI','Products found in the SIRI database, a compilation of Material Safety Data Sheets (MSDS). Note the database may no longer be maintained.','http://hazard.com/msds/index.php','2019-02-27',1,'CPDat 4.0.0-alpha.3','2024-03-13');

-- ********************************************************************************************
-- chemexpo.mv_t_ccd_general_use_keywords
INSERT INTO chemexpo.mv_t_ccd_general_use_keywords (id,keyword_set,source_count,dtxsid,data_version,export_date) VALUES
	 (40511,'OEHHA Proposition 65 (3/2019)',1,'DTXSID7020182','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (40512,'detected, Europe, Toys and children''s products',2,'DTXSID7020182','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (40513,'Europe, nondetect, Other direct contact consumer goods',3,'DTXSID7020182','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (40514,'detected, Europe, Other direct contact consumer goods',6,'DTXSID7020182','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (40515,'artificial_sweat, detected, emissions, Europe, Other direct contact consumer goods',2,'DTXSID7020182','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (51874,'active_ingredient, agricultural, animal_feed, applied, Pesticides',2,'DTXSID9020112','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (51875,'OEHHA Proposition 65 (3/2019)',1,'DTXSID9020112','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (51876,'agricultural, detected, ground_water, Pesticides',1,'DTXSID9020112','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (51877,'agricultural, detected, fruits_and_vegetables, Pesticides, residue',27,'DTXSID9020112','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (51878,'agricultural, detected, drinking_water, Pesticides, residue',22,'DTXSID9020112','CPDat 4.0.0-alpha.3','2024-03-13');

-- ********************************************************************************************
-- chemexpo.mv_t_ccd_product_use_category
INSERT INTO chemexpo.mv_t_ccd_product_use_category (id,dtxsid,display_puc,puc_kind,prod_count,gen_cat,prod_fam,prod_type,puc_definition,data_version,export_date) VALUES
	 (14261,'DTXSID7020182','Construction:construction adhesives','Occupation',1,'Construction','construction adhesives','','Adhesives used in construction applications','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (1285,'DTXSID7020182','Raw materials:coatings','Occupation',55,'Raw materials','coatings','','Coatings manufactured for commercial use.','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (15487,'DTXSID7020182','Raw materials','Occupation',4,'Raw materials','','','Pure chemicals or ingredients','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (17160,'DTXSID7020182','Industrial products:industrial lubricants','Occupation',2,'Industrial products','industrial lubricants','','Lubricants, greases, and oils used in an industrial setting','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (17926,'DTXSID7020182','Medical/dental','Occupation',2,'Medical/dental','','','Medical and dental supplies and equipment, e.g. medical equipment used in a hospital or doctor''s office setting, at home (e.g. wheelchairs), Excludes medical testing supplies. See Medical PPE for clothing and personal protective equipment used in medical settings (e.g. scrubs, face masks, gowns, gloves); See Personal Care - Ostomy products for ostomy related products used in home settings.','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (3424,'DTXSID9020112','Raw materials:coatings','Occupation',4,'Raw materials','coatings','','Coatings manufactured for commercial use.','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (10050,'DTXSID9020112','Landscape/yard:lawn fertilizer','Formulation',1,'Landscape/yard','lawn fertilizer','','fertilizers for lawns, including in combination with pest/weed controllers','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (5302,'DTXSID9020112','Not yet Categorized',NULL,6,'Not yet Categorized',NULL,NULL,NULL,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (12627,'DTXSID9020112','Laboratory supplies','Occupation',18,'Laboratory supplies','','','Products specifically used in a laboratory setting, e.g. laboratory diagnostics or consumables, solvents and reagents used in experiments or laboratory tests, etc. Includes supplies for medical testing. Note that pure chemicals will be included in the ''Raw materials'' category.','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (20414,'DTXSID9020112','Landscape/yard:herbicide','Formulation',1,'Landscape/yard','herbicide','','products used to control or kill unwanted plants','CPDat 4.0.0-alpha.3','2024-03-13');

-- ********************************************************************************************
-- chemexpo.mv_t_ccd_reported_functional_use
INSERT INTO chemexpo.mv_t_ccd_reported_functional_use (id,dtxsid,function_category,reported_function,data_version,export_date) VALUES
	 (28665,'DTXSID7020182','Hardener','hardener','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (3071,'DTXSID7020182','Antioxidant','antioxidants>phenolics','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (4351,'DTXSID7020182','Binder','binder','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (5717,'DTXSID7020182','Catalyst','catalyst','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (9261,'DTXSID7020182','Hardener','curing agent','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (28971,'DTXSID9020112','Biocide','Herbicide','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (29101,'DTXSID9020112','Degradant/impurity (EPA)','herbicide or degradate','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (29112,'DTXSID9020112','Degradant/impurity (EPA)','herbicides and degradates','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (29139,'DTXSID9020112','Degradant/impurity (EPA)','Herbicides and herbicide degradates','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (35791,'DTXSID9020112','Biocide','pesticide','CPDat 4.0.0-alpha.3','2024-03-13');

-- ********************************************************************************************
-- chemexpo.mv_t_functional_use_category
INSERT INTO chemexpo.mv_t_functional_use_category (id,created_at,updated_at,function_category,function_definition,created_by_id,updated_by_id,data_version,export_date) VALUES
	 (36,'2021-02-12','2021-02-12','Deflocculant','Chemical substance used to fluidize concentrated slurries to reduce their bulk viscosity or stickiness in processing or handling. See closely related: anti-caking agent.',23,23,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (37,'2021-02-12','2021-02-12','Defoamer','Chemical substance that controls foam; prevents foam from forming; breaks down any foam that does form; and reduces foaming from proteins, gases, or nitrogenous materials. Reduces the tendency of finished products to generate foam upon shaking or agitation. The ability of a material to act as antifoam depends on its tendency to concentrate on the surface of existing or forming bubbles and to disrupt the continuous films of liquid surrounding them. Used as a process aid to improve filtration, dewatering, washing, and drainage of many types of suspensions, mixtures, and slurries. Also referred to as an antifoaming agent.',23,23,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (38,'2022-08-04','2023-06-05','Degradant/impurity (EPA)','Chemical substance reported as a degradant, impurity, contaminant, etc.',23,4,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (39,'2021-02-12','2021-02-12','Dehydrating agent (desiccant)','Chemical substance used to absorb and remove water from gases or liquids to induce or maintain a state of dryness. Substances are usually hygroscopic materials. See closely related: humectant; adsorbent.',23,23,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (40,'2021-02-12','2021-02-12','Demulsifier','Chemical substance used to destroy an emulsion or prevent its formation.',23,23,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (41,'2021-02-12','2021-02-12','Density modifier','Chemical substance that modifies the density of a material. Also referred to as density modifying agents. See closely related: viscosity modifier; thickening agent.',23,23,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (42,'2021-02-12','2021-02-12','Deodorizer','Chemical substance that reduces or eliminates unpleasant odour and protects against the formation of malodour on body surfaces. Counteraction, sometimes referred to as neutralization, occurs when two odorous substances are mixed in a given ratio and the resulting odour of the mixture is less intense than that of the separate components. Also referred to as a deodorizing agent.',23,23,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (8,'2021-02-12','2021-02-12','Anti-caking agent','Chemical substance that prevents granular or particulate materials from sticking or caking during transfer, storage, or use. See closely related: deflocculant.',23,23,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (9,'2021-02-12','2021-02-12','Anti-condensation agent','Chemical substance or material that is used to avoid condensation on surfaces and in the atmosphere. Also referred to as an anti-dim agent or condensation remover.',23,23,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (10,'2022-06-09','2022-06-09','Anti-dandruff (EPA)','An agent intended to reduce the formation of dandruff flakes on scalp.',23,23,'CPDat 4.0.0-alpha.3','2024-03-13');

-- ********************************************************************************************
-- chemexpo.mv_t_functional_use_resource
INSERT INTO chemexpo.mv_t_functional_use_resource (id,dtxsid,data_type,doc_id,doc_title,doc_date,reported_function,function_category,data_version,export_date) VALUES
	 (221654,'DTXSID7020182','Function',1631119,'4','','phenolics',NULL,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (221655,'DTXSID7020182','Function',1630343,'Octolite 485','','antioxidants>phenolics','Antioxidant','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (221656,'DTXSID7020182','Chemical presence list',1371471,'The 25 Chemicals Found in All Nine of the Biosolids Studied','','fire retardant','Flame retardant','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (221657,'DTXSID7020182','Function',1514560,'4,4''-isopropylidenediphenol','','not reported','No specific technical function','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (221658,'DTXSID7020182','Composition',1550827,'Thin-Set_Epoxy_Terrazzo_Flooring-Master_Terrazzo_Technologies-2017-02-02','february 2, 2017','epoxy hardener',NULL,'CPDat 4.0.0-alpha.3','2024-03-13'),
	 (264610,'DTXSID9020112','Chemical presence list',1400443,'Pesticide Data Program Annual Summary, Calendar Year 2017 - APPENDIX E - Bottled Water','December 2018','Herbicide','Biocide','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (264611,'DTXSID9020112','Chemical presence list',1400423,'Pesticide Data Program Annual Summary, Calendar Year 2017 - APPENDIX B - Lettuce','December 2018','Herbicide','Biocide','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (264612,'DTXSID9020112','Chemical presence list',1400433,'Pesticide Data Program Annual Summary, Calendar Year 2017 - APPENDIX B - Asparagus','December 2018','Herbicide','Biocide','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (264613,'DTXSID9020112','Chemical presence list',1400457,'Pesticide Data Program Annual Summary, Calendar Year 2016 - APPENDIX B - Spinach','February 2018','Herbicide','Biocide','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (264614,'DTXSID9020112','Chemical presence list',1400446,'Pesticide Data Program Annual Summary, Calendar Year 2016 - APPENDIX B - Lettuce','February 2018','Herbicide','Biocide','CPDat 4.0.0-alpha.3','2024-03-13');
	 
-- ********************************************************************************************
-- chemexpo.mv_t_list_presence
INSERT INTO chemexpo.mv_t_list_presence (id,dtxsid,doc_id,doc_title,doc_subtitle,doc_date,organization,reported_function,function_category,component,keyword_set,data_version,export_date) VALUES
	 (24597,'DTXSID7020182',1371471,'The 25 Chemicals Found in All Nine of the Biosolids Studied','median concentrations are normalized to organic carbon and are given in micorgrams per kilogram of organic carbon (µg/kg OC)','','USGS','fire retardant','Flame retardant','','detected; wastewater','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (31967,'DTXSID7020182',1372153,'Emission and evaluation of chemical substances from selected electrical and electronic products- Table 2.10','Table 2.10 Unwanted substances in electric and electronic equipment according to the UMP system.','2003','Danish Environmental Protection Agency',NULL,NULL,'','Cons electronics mech appliances and machinery; Europe','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (21358,'DTXSID7020182',1370059,'FDA Cumulative Estimated Daily Intake','The database lists publicly available cumulative estimated daily intakes (CEDIs) for a large number of food contact substances','','FDA',NULL,NULL,'','CEDI','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (28659,'DTXSID7020182',1372108,'Annex to the HYDROCHECK procedure for acceptance of Materials in contact with Drinking Water','1.2 Compounds that may be used in the manufacture of plastics, elastomers and natural and synthetic rubber products','23 March 2010','Belgaqua',NULL,NULL,'','drinking_water; Europe; manufacturing; plastic_additive','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (43751,'DTXSID7020182',1372213,'Indirect Additives used in Food Contact Substances','FDA authorizes Indirect Food Additives by identity, intended use, and conditions of use; the presence of a substance in this list indicates that only certain intended uses and use conditions are authorized by FDA regulations','10/4/2018','FDA',NULL,NULL,'','Indirect additives food contact (10/2018)','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (18,'DTXSID9020112',1359521,'Sampling For Pesticide Residues in California Well Water','Table 5. Pesticide detections and concentrations reported by DPR from July 2009 through June 2010','May, 2011','California Environmental Protection Agency',NULL,NULL,'','agricultural; detected; ground_water; Pesticides','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (1916,'DTXSID9020112',1359528,'Pesticides Sold In California For Year: 2000','','2000','State of California',NULL,NULL,'','active_ingredient; Pesticides','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (2245,'DTXSID9020112',1359529,'Pesticides Sold In California For Year: 2001','','2001','State of California',NULL,NULL,'','active_ingredient; Pesticides','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (2580,'DTXSID9020112',1359530,'Pesticides Sold In California For Year: 2002','','2002','State of California',NULL,NULL,'','active_ingredient; Pesticides','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (3028,'DTXSID9020112',1359531,'Pesticides Sold In California For Year: 2003','','2003','State of California',NULL,NULL,'','active_ingredient; Pesticides','CPDat 4.0.0-alpha.3','2024-03-13');

-- ********************************************************************************************
-- chemexpo.mv_t_list_presence_tags
INSERT INTO chemexpo.mv_t_list_presence_tags (id,lp_tag_name,lp_tag_definition,lp_tag_kind,data_version,export_date) VALUES
	 (46,'Cleaning products and household care - shoes','Products related to the care of footwear which do not fit into a more refined category','PUC - formulation','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (47,'Cleaning products and household care - shoes - shoe polish or protectant','products applied to footwear to color, polish, clean, or add a protective surface','PUC - formulation','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (48,'Cons electronics mech appliances and machinery','Including small and large consumer electronics appliances (e.g. refrigerator, washing machine, vacuum cleaner, computer, phone, smoke detector, electric tools, lamps); includes small electronics with direct personal contact such as massagers; excludes electronics specifically intended for use by children; excludes electronics with direct food contact (e.g. electric blender)','PUC - article','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (49,'Construction and building materials','Materials used for construction (e.g. flooring, tile, sinks, bathtubs, mirrors, wall materials/drywall, wall-to-wall carpets, insulation, playground surfaces); includes  semi-permanent fixtures such as faucets and light fixtures','PUC - article','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (50,'consumer_product','Indicated as related to, or in, consumer products, but with no more specific information designating product category','General use','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (51,'cotton','of or related to the growing of cotton, or processed cotton used as a textile for consumer goods','Foods & Agriculture','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (52,'dairy','milk and foods produced from or containing milk','Foods & Agriculture','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (53,'detected','chemicals measured or identified in environmental media or products','Modifiers','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (54,'drinking_water','water intended for drinking, or related to drinking water; includes bottled water, finished water from drinking water treatment plants, and untreated water that has been denoted as a drinking source','Media','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (136,'Pesticides','Relating to pesticides or pesticide usage. Includes specific types of pesticides, e.g. insecticides,  herbicides, fungicides, and fumigants; also includes general biocides','PUC - formulation','CPDat 4.0.0-alpha.3','2024-03-13');

-- ********************************************************************************************
-- chemexpo.mv_t_product_data
	 INSERT INTO chemexpo.mv_t_product_data (id,dtxsid,doc_id,doc_title,doc_date,prod_name,gen_cat,prod_fam,prod_type,classification_method,raw_min_comp,raw_max_comp,raw_central_comp,unit_type,lower_weight_fraction,upper_weight_fraction,central_weight_fraction,weight_fraction_type,component,data_version,export_date) VALUES
	 (10934,'DTXSID7020182',1098930,'EPOLITE 2152 HARDENER',' 03/09/1992',' epolite 2152 hardener','Raw materials','adhesives','','Manual Batch','30','45','','percent',0.300000000000000,0.450000000000000,NULL,'reported','','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (12328,'DTXSID7020182',1099279,'HYSOL KS4008 PART B KB4008, KS4008',' 02/12/1992',' hysol ks4008 part b kb4008_ ks4008','Specialty occupational products','aviation','','Manual Batch','1','15','','percent',0.010000000000000,0.150000000000000,NULL,'reported','','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (169768,'DTXSID7020182',1153212,'PRIMER COATING, EPOXY PART B 09 ID724116','08/16/1988','primer coating_ epoxy part b 09 id724116','Home maintenance','paint/stain and related products','','Manual Batch','','','',NULL,NULL,NULL,NULL,'reported','','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (18357,'DTXSID7020182',1100923,'SCOTCH-WELD EC-3578 B/A PART A STRUCTURAL (SUPDAT)',' 08/12/1993',' scotch-weld ec-3578 b/a part a structural (supdat)','Home maintenance','adhesives and adhesive removers','multipurpose adhesive','Manual Batch','1','10','','percent',0.010000000000000,0.100000000000000,NULL,'reported','','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (174406,'DTXSID7020182',1154642,'RP 1250 HARDENER','12/07/1989','rp 1250 hardener','Raw materials','coatings','','Manual Batch','','',' 1.665','percent',NULL,NULL,0.016650000000000,'reported','','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (254841,'DTXSID9020112',1177078,'PS-380 ATRAZINE, 99.5% PURE','07/10/1990','ps-380 atrazine_ 99.5% pure','Laboratory supplies','','','Manual Batch','','',' 99.5','percent',NULL,NULL,0.995000000000000,'reported','','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (100108,'DTXSID9020112',1124982,'atrazine','11/25/1985','atrazine technical','Raw materials','coatings','','Manual Batch','','','',NULL,NULL,NULL,NULL,'reported','','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (111919,'DTXSID9020112',1129373,'ATRATOL 80W','01/01/1985','atratol 80w','Raw materials','coatings','','Manual Batch','','',' 71.3','percent',NULL,NULL,0.713000000000000,'reported','','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (140486,'DTXSID9020112',1142632,'ATRAZINE 80W','01/01/1985','atrazine 80w',NULL,NULL,NULL,NULL,'','',' 76.0','percent',NULL,NULL,0.760000000000000,'reported','','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (140487,'DTXSID9020112',1142633,'AATRAX 80W','05/01/1989','aatrax 80w','Raw materials','coatings','','Manual Batch','','','',NULL,NULL,NULL,NULL,'reported','','CPDat 4.0.0-alpha.3','2024-03-13');

-- ********************************************************************************************
-- chemexpo.mv_t_puc
INSERT INTO chemexpo.mv_t_puc (id,puc_kind,gen_cat,prod_fam,prod_type,puc_definition,data_version,export_date) VALUES
	 (254,'Formulation','Personal care','sexual wellness','','sexual wellness products, including personal lubricants','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (257,'Formulation','Personal care','shaving and hair removal','clipper lubricant/cleaner','cleaning and lubricating products for hair clippers','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (260,'Formulation','Personal care','shaving and hair removal','waxing','products for removing hair by waxing','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (263,'Formulation','Personal care','specialized bath products','bath salts','solid or powdered products added to bathwater including bath salts, soaks,  and fizzes','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (266,'Formulation','Pesticides','','','general pesticide products that do not fit into a more refined category','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (269,'Formulation','Pesticides','insect repellent','','miscellaneous products for repelling insects, including citronella type candles (excluding products to be applied to the skin)','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (272,'Formulation','Pesticides','rodenticide','','rodenticides for interior or exterior use','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (275,'Formulation','Pet and animal care','all pets','other pet treatments','miscellaneous pet treatments (excluding pesticides and shampoos)','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (48,'Formulation','Arts and crafts/office supplies','pottery making','','products related to pottery making which can not be assigned to a more refined category','CPDat 4.0.0-alpha.3','2024-03-13'),
	 (51,'Formulation','Arts and crafts/office supplies','home office','pens and markers','writing utensils containing liquid or gel ink','CPDat 4.0.0-alpha.3','2024-03-13');

-- ********************************************************************************************
-- prodvol.mv_production_volume
INSERT INTO prodvol.mv_production_volume (id,dtxsid,name,amount,data_version,export_date) VALUES
	 (23113,'DTXSID7020182','2019 NATIONALLY AGGREGATED PV','1,000,000,000 - <5,000,000,000 lb',NULL,NULL),
	 (23114,'DTXSID7020182','2018 NATIONALLY AGGREGATED PV','1,000,000,000 - <5,000,000,000 lb',NULL,NULL),
	 (23115,'DTXSID7020182','2017 NATIONALLY AGGREGATED PV','1,000,000,000 - <5,000,000,000 lb',NULL,NULL),
	 (23116,'DTXSID7020182','2016 NATIONALLY AGGREGATED PV','1,000,000,000 - <5,000,000,000 lb',NULL,NULL);
	 
-- ********************************************************************************************
-- ep.v_demo_expo_predictions
INSERT INTO ep.v_demo_expo_predictions (dtxsid,demographic,predictor,median,median_text,l95,l95_text,u95,u95_text,units,ad,reference,data_version,import_date) VALUES
	 ('DTXSID7020182','Total','SEEM3 Consensus',0.00005497,'5.497e-05',0.0000001923,'1.923e-07',0.02044,'0.02044','mg/kg/day',1,'Ring 2018',NULL,'2024-06-13 19:25:16.277'),
	 ('DTXSID7020182','Total','RAIDAR',3.77,'3.77',NULL,'NA',NULL,'NA','mg/kg/day',1,'Arnot 2008',NULL,'2024-06-13 19:25:16.277'),
	 ('DTXSID7020182','Total','Food.Contact',0.01766,'0.01766',NULL,'NA',NULL,'NA','mg/kg/day',1,'Biryol 2017',NULL,'2024-06-13 19:25:16.277'),
	 ('DTXSID7020182','Repro. Age Females','SEEM2 Heuristic',0.0000136427543462,'1.36427543462443e-05',0.0000000563723994,'5.63723993835891e-08',0.00417661734132225,'0.00417661734132225','mg/kg/day',1,'Wambaugh 2014',NULL,'2024-06-13 19:25:16.277'),
	 ('DTXSID7020182','Males','SEEM2 Heuristic',0.0000386795578538,'3.86795578537834e-05',0.0000002846710579,'2.84671057884619e-07',0.00630617035849566,'0.00630617035849566','mg/kg/day',1,'Wambaugh 2014',NULL,'2024-06-13 19:25:16.277'),
	 ('DTXSID9020112','Total','SEEM3 Consensus',0.000001078,'1.078e-06',0.00000005699,'5.699e-08',0.00004097,'4.097e-05','mg/kg/day',1,'Ring 2018',NULL,'2024-06-13 19:25:16.277'),
	 ('DTXSID9020112','Repro. Age Females','SEEM2 Heuristic',0.0000000716578647,'7.16578647071334e-08',0.0000000004883319,'4.88331915419912e-10',0.0000109439954847,'1.09439954847333e-05','mg/kg/day',1,'Wambaugh 2014',NULL,'2024-06-13 19:25:16.277'),
	 ('DTXSID9020112','Males','SEEM2 Heuristic',0.0000000598826671,'5.98826671150384e-08',0.000000000291714,'2.91714042663302e-10',0.0000056354793692,'5.63547936916725e-06','mg/kg/day',1,'Wambaugh 2014',NULL,'2024-06-13 19:25:16.277'),
	 ('DTXSID9020112','Females','SEEM2 Heuristic',0.0000000726909268,'7.26909267783965e-08',0.0000000003156373,'3.15637339442872e-10',0.0000105562943666,'1.05562943665932e-05','mg/kg/day',1,'Wambaugh 2014',NULL,'2024-06-13 19:25:16.277'),
	 ('DTXSID9020112','Age 6-11','SEEM2 Heuristic',0.0000000691288865,'6.91288865396105e-08',0.0000000002935982,'2.93598186315655e-10',0.0000164312132374,'1.64312132373716e-05','mg/kg/day',1,'Wambaugh 2014',NULL,'2024-06-13 19:25:16.277');

-- ********************************************************************************************
-- ep.v_gen_expo_predictions
INSERT INTO ep.v_gen_expo_predictions (dtxsid,production_volume,units,stockholm_convention,probability_dietary,probability_residential,probability_pesticde,probability_industrial,data_version,import_date) VALUES
	 ('DTXSID7020182',2780000,'kg/day',0,1.0000,1.0000,0.0000,0.0000,NULL,'2024-06-13 22:07:19.484'),
	 ('DTXSID9020112',31.1,'kg/day',0,0.0000,1.0000,1.0000,0.0000,NULL,'2024-06-13 22:07:19.484');

-- ********************************************************************************************
-- ep.v_httk_data
INSERT INTO ep.v_httk_data (dtxsid,parameter,measured,measured_text,predicted,predicted_text,units,model,reference,percentile,species,data_source_species,data_version,import_date) VALUES
	 ('DTXSID7020182','Css',0.0083,'0.0083',1.114,'1.114','mg/L','PBTK','Wambaugh et al. (2018)','95%','Rat','Rat',NULL,'2024-06-13 16:53:14.622'),
	 ('DTXSID7020182','Css',0.0083,'0.0083',0.5297,'0.5297','mg/L','PBTK','Wambaugh et al. (2018)','50%','Rat','Rat',NULL,'2024-06-13 16:53:14.622'),
	 ('DTXSID7020182','Css',0.0083,'0.0083',1.076,'1.076','mg/L','3compartmentss','Wambaugh et al. (2018)','95%','Rat','Rat',NULL,'2024-06-13 16:53:14.622'),
	 ('DTXSID7020182','Css',0.0083,'0.0083',0.5116,'0.5116','mg/L','3compartmentss','Wambaugh et al. (2018)','50%','Rat','Rat',NULL,'2024-06-13 16:53:14.622'),
	 ('DTXSID7020182','TK.Half.Life',0.19,'0.19',139.5,'139.5','hours','1compartment','Wambaugh et al. (2018)','NA','Rat','Rat',NULL,'2024-06-13 16:53:14.622'),
	 ('DTXSID9020112','Css',NULL,'NA',0.1595,'0.1595','mg/L','PBTK','NA','95%','Rat','Human',NULL,'2024-06-13 16:53:14.622'),
	 ('DTXSID9020112','Css',NULL,'NA',0.03152,'0.03152','mg/L','PBTK','NA','50%','Rat','Human',NULL,'2024-06-13 16:53:14.622'),
	 ('DTXSID9020112','Css',NULL,'NA',0.154,'0.154','mg/L','3compartmentss','NA','95%','Rat','Human',NULL,'2024-06-13 16:53:14.622'),
	 ('DTXSID9020112','Css',NULL,'NA',0.03043,'0.03043','mg/L','3compartmentss','NA','50%','Rat','Human',NULL,'2024-06-13 16:53:14.622'),
	 ('DTXSID9020112','TK.Half.Life',NULL,'NA',1.943,'1.943','hours','1compartment','NA','NA','Rat','Human',NULL,'2024-06-13 16:53:14.622');

-- ********************************************************************************************
-- qsur.mv_qsur_data
INSERT INTO qsur.mv_qsur_data (id,dtxsid,harmonized_functional_use,probability,data_version,export_date) VALUES
	 (NULL,'DTXSID7020182','antimicrobial',0.3722,NULL,NULL),
	 (NULL,'DTXSID7020182','antioxidant',0.8941,NULL,NULL),
	 (NULL,'DTXSID7020182','catalyst',0.2031,NULL,NULL),
	 (NULL,'DTXSID7020182','colorant',0.156,NULL,NULL),
	 (NULL,'DTXSID7020182','crosslinker',0.7743,NULL,NULL),
	 (NULL,'DTXSID9020112','antimicrobial',0.9121,NULL,NULL);

-- ********************************************************************************************
-- mmdb.mv_mmdb_aggregate
INSERT INTO mmdb.mv_mmdb_aggregate (id,full_source_name,reported_chemical_name,dtxsid,preferred_name,reported_casrn,casrn,reported_result,reported_units,cleaned_units,reported_statistic,reported_n,lod,loq,reported_num_detects,reported_num_nds,reported_detect_rate,detected,detect_conflict,detect_note,reported_species,reported_media,harmonized_medium,reported_population,reported_subpopulation,reported_collection_activity_id,reported_dates,years,reported_location,state_or_province,us_county,country,qc_flag,reported_link,reported_reference,data_version,export_date) VALUES
	 (34655706,'Information Platform for Chemical Monitoring Data - Biomonitoring                                                       ','total bisphenol a','DTXSID7020182','Bisphenol A',NULL,'80-05-7','2.2425','µg/l','µg/L','75% percentile','60',NULL,'0.1',NULL,NULL,NULL,1,0,'Unambiguous detect','Students (24h-sampling urine)','Human (24h-sampling urine)','urine',NULL,NULL,NULL,'2007',NULL,'Germany',NULL,NULL,'Germany','IPCheM-U705: CAS Number missing {""Chemical Name"":""total bisphenol a""},',NULL,NULL,'v1.1','2025-01-29'),
	 (34655762,'Information Platform for Chemical Monitoring Data - Biomonitoring                                                       ','total bisphenol a','DTXSID7020182','Bisphenol A',NULL,'80-05-7','9.97','µg/l','µg/L','Maximum','30',NULL,'0.1',NULL,NULL,NULL,1,0,'Unambiguous detect','Students (24h-sampling urine)','Human (24h-sampling urine)','urine',NULL,NULL,NULL,'2006',NULL,'Germany',NULL,NULL,'Germany','IPCheM-U705: CAS Number missing {""Chemical Name"":""total bisphenol a""},',NULL,NULL,'v1.1','2025-01-29'),
	 (63651875,'Comparative Toxicogenomics Database                                                                                     ','bisphenol A','DTXSID7020182','Bisphenol A','80-05-7','80-05-7','0.11','micrograms per liter','µg/L','95th percentile',NULL,'0.03',NULL,NULL,NULL,'23.4',1,0,'Unambiguous detect',NULL,'urine','urine','Pregnant females','first trimester',NULL,'2008-2011',NULL,'Canada',NULL,NULL,NULL,NULL,'http://ctdbase.org/detail.go?type=reference&acc=25494523','25494523','v1.1','2025-01-29'),
	 (63651957,'Comparative Toxicogenomics Database                                                                                     ','bisphenol A','DTXSID7020182','Bisphenol A','80-05-7','80-05-7','1.3','micrograms per liter','µg/L','geometric mean',NULL,'0.2',NULL,NULL,NULL,NULL,1,0,'Unambiguous detect',NULL,'urine','urine','Pregnant females','total urine volume less than 40 mL',NULL,'2009-2011',NULL,'Canada','Ontario',NULL,NULL,'NoNumObs,','http://ctdbase.org/detail.go?type=reference&acc=25483107','25483107','v1.1','2025-01-29'),
	 (63653011,'Comparative Toxicogenomics Database                                                                                     ','bisphenol A','DTXSID7020182','Bisphenol A','80-05-7','80-05-7','3.7','nanograms per milliliter','ng/mL','75th percentile',NULL,'0.4',NULL,NULL,NULL,'93',1,0,'Unambiguous detect',NULL,'urine','urine','Study subjects',NULL,NULL,'2005-2006',NULL,'United States',NULL,NULL,NULL,NULL,'http://ctdbase.org/detail.go?type=reference&acc=20237498','20237498','v1.1','2025-01-29'),
	 (30464941,'Information Platform for Chemical Monitoring Data - Lakes and Rivers                                                    ','Atrazine','DTXSID9020112','Atrazine','1912-24-9','1912-24-9','0.03','µg/l','µg/L','Minimum','12',NULL,'0.03',NULL,'12',NULL,0,0,'Unambiguous non-detect',NULL,NULL,'surface water',NULL,NULL,'647949',NULL,'2010','FR',NULL,NULL,'France',NULL,NULL,NULL,'v1.1','2025-01-29'),
	 (49233242,'EPA Discharge Monitoring Report Data                                                                                    ','Atrazine','DTXSID9020112','Atrazine','1912249','1912-24-9',NULL,'mg/L','mg/L',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'No detection rate or result reported',NULL,NULL,'wastewater (influent, effluent)',NULL,NULL,NULL,NULL,'2015','PIMA COUNTY - WWMD - AVRA VALLEY WWTF','AZ',NULL,NULL,'NoConcentration,NoNumObs,',NULL,NULL,'v1.1','2025-01-29'),
	 (49294210,'EPA Discharge Monitoring Report Data                                                                                    ','Atrazine','DTXSID9020112','Atrazine','1912249','1912-24-9',NULL,'mg/L','mg/L',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,'No detection rate or result reported',NULL,NULL,'wastewater (influent, effluent)',NULL,NULL,NULL,NULL,'2015','TURLOCK RWQCF','CA',NULL,NULL,'NoConcentration,NoNumObs,',NULL,NULL,'v1.1','2025-01-29'),
	 (30887337,'Information Platform for Chemical Monitoring Data - Lakes and Rivers                                                    ','Atrazine','DTXSID9020112','Atrazine','1912-24-9','1912-24-9','0.01','µg/l','µg/L','Minimum','8',NULL,'0.02',NULL,'7',NULL,1,0,'Unambiguous detect',NULL,NULL,'surface water',NULL,NULL,'5108474',NULL,'2012','IT',NULL,NULL,'Italy',NULL,NULL,NULL,'v1.1','2025-01-29'),
	 (49811321,'EPA Discharge Monitoring Report Data                                                                                    ','Atrazine','DTXSID9020112','Atrazine','1912249','1912-24-9','0','mg/L','mg/L',NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,0,'Unambiguous non-detect',NULL,NULL,'wastewater (influent, effluent)',NULL,NULL,NULL,NULL,'2015','CITY OF EL PASO','TX',NULL,NULL,'NoConcentration,NoNumObs,',NULL,NULL,'v1.1','2025-01-29');

-- ********************************************************************************************
-- mmdb.mv_mmdb_media
INSERT INTO mmdb.mv_mmdb_media (id,harmonized_medium,harmonized_medium_description,data_version,export_date) VALUES
	 (1,'ambient air','Outdoor ambient air','v1.1','2025-01-29'),
	 (2,'breast milk','Human breast milk','v1.1','2025-01-29'),
	 (3,'drinking water','Treated or untreated drinking water supplies, tap water, bottled drinking water, cooking water','v1.1','2025-01-29'),
	 (4,'food product','Processed food products, including dairy products, breads, cooked meats, processed (e.g., canned or frozen) fruit and vegetable products, infant formula','v1.1','2025-01-29'),
	 (5,'groundwater','Water from groundwater sources (wells, aquifers)','v1.1','2025-01-29'),
	 (6,'human blood (whole/serum/plasma)','Human whole blood, blood cells, serum, plasma, or other extractants, including fetal or umbilical samples','v1.1','2025-01-29'),
	 (7,'human (other tissues or fluids)','Human tissues or fluids other than blood or urine, including nails, hair, semen, adipose tissue, saliva, sputum, sweat, amniotic, fluid, bone, and others','v1.1','2025-01-29'),
	 (8,'indoor air','Residential or other indoor air samples','v1.1','2025-01-29'),
	 (9,'indoor dust','Residential or other indoor dust samples (from any location), including surface wipes','v1.1','2025-01-29'),
	 (10,'landfill leachate','Landfill leachate (water having passed through landfill solids)','v1.1','2025-01-29');

-- ********************************************************************************************
-- mmdb.mv_mmdb_single_sample
INSERT INTO mmdb.mv_mmdb_single_sample (id,full_source_name,reported_chemical_name,dtxsid,preferred_name,reported_casrn,casrn,reported_result,reported_units,cleaned_units,lod,loq,nd_flag,result_flag,detected,detect_conflict,detect_note,reported_species,reported_media,harmonized_medium,reported_analytical_method,reported_collection_activity_id,reported_sample_id,mmdb_sample_id,reported_dates,sample_year,sample_month,sample_time,reported_location,state_or_province,us_county,country,qc_flag,reported_link,reported_reference,data_version,export_date) VALUES
	 (68636743,'USGS Monitoring Data National Water Quality Monitoring Council - Air, Soil, Biological (Tissue), Sediment, Water        ','4,4''-Isopropylidenediphenol','DTXSID7020182','Bisphenol A',NULL,'80-05-7',NULL,'ug/l','µg/L',NULL,'0.15','Not Detected',NULL,0,0,'Unambiguous non-detect',NULL,'Water','surface water','EPA/NPS-EC Non-Volatile Waste Indicators in Water by Gas Chromatography-Mass Spectrometry','11NPSWRD_WQX-CARE_3P_4954360-201007060915SR_B',NULL,'168_106357','2010-07-06','2010',NULL,NULL,'11NPSWRD_WQX-CARE_3P_4954360','UT',NULL,'United States',NULL,NULL,'STORET','v1.1','2025-01-29'),
	 (68640516,'USGS Monitoring Data National Water Quality Monitoring Council - Air, Soil, Biological (Tissue), Sediment, Water        ','4,4''-Isopropylidenediphenol','DTXSID7020182','Bisphenol A',NULL,'80-05-7',NULL,'ug/l','µg/L',NULL,'0.15','Not Detected',NULL,0,0,'Unambiguous non-detect',NULL,'Water','surface water','EPA/NPS-EC Non-Volatile Waste Indicators in Water by Gas Chromatography-Mass Spectrometry','11NPSWRD_WQX-HOVE_3P_5995710-201011151000SR_B',NULL,'168_120292','2010-11-15','2010',NULL,NULL,'11NPSWRD_WQX-HOVE_3P_5995710','UT',NULL,'United States',NULL,NULL,'STORET','v1.1','2025-01-29'),
	 (221535654,'Information Platform for Chemical Monitoring Data - IBS                                                                 ','bisphenol a','DTXSID7020182','Bisphenol A','80-05-7','80-05-7','3.757','µg/L','µg/L','0.1','0.3',NULL,NULL,1,0,'Unambiguous detect',NULL,'Human (Urine)','urine',NULL,NULL,'202','195_5',NULL,'2011',NULL,NULL,'Israel',NULL,NULL,'Israel',NULL,NULL,NULL,'v1.1','2025-01-29'),
	 (221536198,'Information Platform for Chemical Monitoring Data - IBS                                                                 ','bisphenol a','DTXSID7020182','Bisphenol A','80-05-7','80-05-7','10.47','µg/L','µg/L','0.1','0.3',NULL,NULL,1,0,'Unambiguous detect',NULL,'Human (Urine)','urine',NULL,NULL,'251','195_37',NULL,'2011',NULL,NULL,'Israel',NULL,NULL,'Israel',NULL,NULL,NULL,'v1.1','2025-01-29'),
	 (221538272,'Information Platform for Chemical Monitoring Data - IBS                                                                 ','bisphenol a','DTXSID7020182','Bisphenol A','80-05-7','80-05-7','2.355','µg/L','µg/L','0.1','0.3',NULL,NULL,1,0,'Unambiguous detect',NULL,'Human (Urine)','urine',NULL,NULL,'709','195_159',NULL,'2011',NULL,NULL,'Israel',NULL,NULL,'Israel',NULL,NULL,NULL,'v1.1','2025-01-29'),
	 (68522241,'USGS Monitoring Data National Water Quality Monitoring Council - Air, Soil, Biological (Tissue), Sediment, Water        ','Atrazine','DTXSID9020112','Atrazine',NULL,'1912-24-9','< 3.6','ng/l','ng/L',NULL,'3.6',NULL,NULL,0,0,'Unambiguous non-detect',NULL,'Surface Water','surface water','Non-Volatile Compounds by HPLC','OREGONDEQ-20110715-4',NULL,'168_6858971','2011-08-23','2011',NULL,NULL,'OREGONDEQ-10720-ORDEQ','OR',NULL,'United States',NULL,NULL,'STORET','v1.1','2025-01-29'),
	 (68522423,'USGS Monitoring Data National Water Quality Monitoring Council - Air, Soil, Biological (Tissue), Sediment, Water        ','Atrazine','DTXSID9020112','Atrazine',NULL,'1912-24-9','< 50','ng/l','ng/L',NULL,'50',NULL,NULL,0,0,'Unambiguous non-detect',NULL,'Surface Water','surface water','8270 D ~ Semivolatile Organic Compounds by GC/MS','OREGONDEQ-20110797-1',NULL,'168_6859296','2011-09-20','2011',NULL,NULL,'OREGONDEQ-36801-ORDEQ','OR',NULL,'United States',NULL,NULL,'STORET','v1.1','2025-01-29'),
	 (68526006,'USGS Monitoring Data National Water Quality Monitoring Council - Air, Soil, Biological (Tissue), Sediment, Water        ','Atrazine','DTXSID9020112','Atrazine',NULL,'1912-24-9','0.0364544347718423','ug/l','µg/L',NULL,NULL,NULL,NULL,1,0,'Unambiguous detect',NULL,'Water','surface water','Nitrogen and Phosphorus Pesticides','PCSWD-205375',NULL,'168_6914228','2010-04-12','2010',NULL,NULL,'PCSWD-1782/4.7/3.8/4.3/0.1',NULL,NULL,'United States',NULL,NULL,'STORET','v1.1','2025-01-29'),
	 (68535476,'USGS Monitoring Data National Water Quality Monitoring Council - Air, Soil, Biological (Tissue), Sediment, Water        ','Atrazine','DTXSID9020112','Atrazine',NULL,'1912-24-9','0.7','ug/l','µg/L',NULL,NULL,NULL,NULL,1,0,'Unambiguous detect',NULL,'Water','surface water','Pesticides (Atrazine, Alachlor, Metolachlor, and Acetochlor)','SACFOXMO-Site 407052011SRW',NULL,'168_7041644','2011-07-05','2011',NULL,NULL,'SACFOXMO-Site 4','NE',NULL,'United States',NULL,NULL,'STORET','v1.1','2025-01-29'),
	 (68535484,'USGS Monitoring Data National Water Quality Monitoring Council - Air, Soil, Biological (Tissue), Sediment, Water        ','Atrazine','DTXSID9020112','Atrazine',NULL,'1912-24-9',NULL,NULL,'',NULL,'0.5','Not Detected',NULL,0,0,'Unambiguous non-detect',NULL,'Water','surface water','Pesticides (Atrazine, Alachlor, Metolachlor, and Acetochlor)','SACFOXMO-Site 508092011SRW',NULL,'168_7041755','2011-08-09','2011',NULL,NULL,'SACFOXMO-Site 5','NE',NULL,'United States','NoUnits,',NULL,'STORET','v1.1','2025-01-29');
