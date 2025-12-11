CREATE SCHEMA nhanes;

CREATE TABLE nhanes.biomonitor_data (
	id serial4 NOT NULL,
	dtxsid varchar NULL,
	demographic_group varchar NULL,
	intake_rate_mgpkgpday float8 NULL,
	low95 float8 NULL,
	up95 float8 NULL,
	nhanes_cohort varchar NULL,
	data_version varchar NULL,
	export_date date NULL
);

CREATE SCHEMA chemexpo;

CREATE TABLE chemexpo.mv_t_ccd_chemical_weight_fractions (
	id int8 NULL,
	dtxsid varchar(50) NULL,
	prod_name varchar(255) NULL,
	display_puc varchar(202) NULL,
	puc_kind varchar(50) NULL,
	lower_weight_fraction numeric(16, 15) NULL,
	upper_weight_fraction numeric(16, 15) NULL,
	weight_fraction_type varchar(50) NULL,
	gen_cat varchar(50) NULL,
	prod_fam varchar(50) NULL,
	prod_type varchar(100) NULL,
	puc_definition text NULL,
	source_name varchar(50) NULL,
	source_description text NULL,
	source_url varchar(150) NULL,
	source_download_date date NULL,
	prod_count int8 NULL,
	data_version varchar(19) NULL,
	export_date date NULL
);

CREATE TABLE chemexpo.mv_t_ccd_general_use_keywords (
	id int8 NULL,
	keyword_set text NULL,
	source_count int8 NULL,
	dtxsid varchar(50) NULL,
	data_version varchar(19) NULL,
	export_date date NULL
);

CREATE TABLE chemexpo.mv_t_ccd_product_use_category (
	id int8 NULL,
	dtxsid varchar(50) NULL,
	display_puc varchar(202) NULL,
	puc_kind varchar(50) NULL,
	prod_count int8 NULL,
	gen_cat varchar(50) NULL,
	prod_fam varchar(50) NULL,
	prod_type varchar(100) NULL,
	puc_definition text NULL,
	data_version varchar(19) NULL,
	export_date date NULL
);

CREATE TABLE chemexpo.mv_t_ccd_reported_functional_use (
	id int8 NULL,
	dtxsid varchar(50) NULL,
	function_category varchar(100) NULL,
	reported_function varchar(255) NULL,
	data_version varchar(19) NULL,
	export_date date NULL
);

CREATE TABLE chemexpo.mv_t_functional_use_category (
	id int8 NULL,
	created_at date NULL,
	updated_at date NULL,
	function_category varchar(100) NULL,
	function_definition text NULL,
	created_by_id int4 NULL,
	updated_by_id int4 NULL,
	data_version varchar(19) NULL,
	export_date date NULL
);

CREATE TABLE chemexpo.mv_t_functional_use_resource (
	id int8 NULL,
	dtxsid varchar(50) NULL,
	data_type varchar(50) NULL,
	doc_id int4 NULL,
	doc_title varchar(500) NULL,
	doc_date varchar(25) NULL,
	reported_function varchar(255) NULL,
	function_category varchar(100) NULL,
	data_version varchar(19) NULL,
	export_date date NULL
);

CREATE TABLE chemexpo.mv_t_list_presence (
	id int8 NULL,
	dtxsid varchar(50) NULL,
	doc_id int4 NULL,
	doc_title varchar(500) NULL,
	doc_subtitle varchar(250) NULL,
	doc_date varchar(25) NULL,
	organization varchar(255) NULL,
	reported_function varchar(255) NULL,
	function_category varchar(100) NULL,
	component varchar(200) NULL,
	keyword_set text NULL,
	data_version varchar(19) NULL,
	export_date date NULL
);

CREATE TABLE chemexpo.mv_t_list_presence_tags (
	id int8 NULL,
	lp_tag_name varchar(100) NULL,
	lp_tag_definition varchar(750) NULL,
	lp_tag_kind varchar(50) NULL,
	data_version varchar(19) NULL,
	export_date date NULL
);

CREATE TABLE chemexpo.mv_t_product_data (
	id int8 NULL,
	dtxsid varchar(50) NULL,
	doc_id int4 NULL,
	doc_title varchar(500) NULL,
	doc_date varchar(25) NULL,
	prod_name varchar(255) NULL,
	gen_cat varchar(50) NULL,
	prod_fam varchar(50) NULL,
	prod_type varchar(100) NULL,
	classification_method varchar(100) NULL,
	raw_min_comp varchar(100) NULL,
	raw_max_comp varchar(100) NULL,
	raw_central_comp varchar(100) NULL,
	unit_type varchar(50) NULL,
	lower_weight_fraction numeric(16, 15) NULL,
	upper_weight_fraction numeric(16, 15) NULL,
	central_weight_fraction numeric(16, 15) NULL,
	weight_fraction_type varchar(50) NULL,
	component varchar(200) NULL,
	data_version varchar(19) NULL,
	export_date date NULL
);

CREATE TABLE chemexpo.mv_t_puc (
	id int8 NULL,
	puc_kind varchar(50) NULL,
	gen_cat varchar(50) NULL,
	prod_fam varchar(50) NULL,
	prod_type varchar(100) NULL,
	puc_definition text NULL,
	data_version varchar(19) NULL,
	export_date date NULL
);

CREATE SCHEMA prodvol;

CREATE TABLE prodvol.mv_production_volume (
	id int4 NULL,
	dtxsid varchar NULL,
	name varchar NULL,
	amount varchar NULL,
	data_version varchar NULL,
	export_date date NULL
);

CREATE SCHEMA ep;

CREATE TABLE ep.v_demo_expo_predictions (
	id serial4 NOT NULL,
	dtxsid varchar(20) NULL,
	demographic varchar(25) NULL,
	predictor varchar(25) NULL,
	median float8 NULL,
	median_text varchar(25) NULL,
	l95 float8 NULL,
	l95_text varchar(25) NULL,
	u95 float8 NULL,
	u95_text varchar(25) NULL,
	units varchar(20) NULL,
	ad int4 NULL,
	reference varchar(20) NULL,
	data_version varchar(50) NULL,
	import_date timestamp DEFAULT now() NULL,
	CONSTRAINT v_demo_expo_predictions_pk PRIMARY KEY (id)
);
CREATE INDEX v_demo_expo_predictions_dtxsid_index ON ep.v_demo_expo_predictions USING btree (dtxsid);

CREATE TABLE ep.v_gen_expo_predictions (
	dtxsid varchar(20) NOT NULL,
	production_volume numeric NULL,
	units varchar(7) NULL,
	stockholm_convention int4 NULL,
	probability_dietary numeric(5, 4) NULL,
	probability_residential numeric(5, 4) NULL,
	probability_pesticde numeric(5, 4) NULL,
	probability_industrial numeric(5, 4) NULL,
	data_version varchar(50) NULL,
	import_date timestamp DEFAULT now() NULL,
	CONSTRAINT v_gen_expo_predictions_pk PRIMARY KEY (dtxsid)
);

CREATE TABLE ep.v_httk_data (
	id serial4 NOT NULL,
	dtxsid varchar(20) NULL,
	parameter varchar(15) NULL,
	measured numeric NULL,
	measured_text varchar(15) NULL,
	predicted numeric NULL,
	predicted_text varchar(15) NULL,
	units varchar(30) NULL,
	model varchar(15) NULL,
	reference varchar(150) NULL,
	percentile varchar(5) NULL,
	species varchar(10) NULL,
	data_source_species varchar(10) NULL,
	data_version varchar(50) NULL,
	import_date timestamp DEFAULT now() NULL,
	CONSTRAINT v_httk_data_pk PRIMARY KEY (id)
);
CREATE INDEX v_httk_data_dtxsid_index ON ep.v_httk_data USING btree (dtxsid);

CREATE SCHEMA qsur;

CREATE TABLE qsur.mv_qsur_data (
	id int4 NULL,
	dtxsid varchar(50) NULL,
	harmonized_functional_use varchar(50) NULL,
	probability numeric NULL,
	data_version varchar NULL,
	export_date date NULL
);

CREATE SCHEMA mmdb;

CREATE TABLE mmdb.mv_mmdb_aggregate (
	id int8 NULL,
	full_source_name bpchar(120) NULL,
	reported_chemical_name varchar(200) NULL,
	dtxsid varchar(20) NULL,
	preferred_name varchar(300) NULL,
	reported_casrn varchar(50) NULL,
	casrn varchar(20) NULL,
	reported_result varchar NULL,
	reported_units varchar(100) NULL,
	cleaned_units varchar NULL,
	reported_statistic varchar(100) NULL,
	reported_n varchar NULL,
	lod varchar NULL,
	loq varchar NULL,
	reported_num_detects varchar NULL,
	reported_num_nds varchar NULL,
	reported_detect_rate varchar NULL,
	detected int4 NULL,
	detect_conflict int4 NULL,
	detect_note varchar NULL,
	reported_species varchar(200) NULL,
	reported_media varchar(120) NULL,
	harmonized_medium varchar(200) NULL,
	reported_population varchar(500) NULL,
	reported_subpopulation varchar NULL,
	reported_collection_activity_id varchar(100) NULL,
	reported_dates varchar NULL,
	years varchar NULL,
	reported_location varchar(500) NULL,
	state_or_province varchar NULL,
	us_county varchar(60) NULL,
	country varchar NULL,
	qc_flag varchar(200) NULL,
	reported_link varchar(500) NULL,
	reported_reference varchar(300) NULL,
	data_version text NULL,
	export_date date NULL
);

CREATE TABLE mmdb.mv_mmdb_media (
	id int8 NULL,
	harmonized_medium text NULL,
	harmonized_medium_description text NULL,
	data_version text NULL,
	export_date date NULL
);

CREATE TABLE mmdb.mv_mmdb_single_sample (
	id int8 NULL,
	full_source_name bpchar(120) NULL,
	reported_chemical_name varchar(200) NULL,
	dtxsid varchar(20) NULL,
	preferred_name varchar(300) NULL,
	reported_casrn varchar(50) NULL,
	casrn varchar(20) NULL,
	reported_result varchar(100) NULL,
	reported_units varchar(100) NULL,
	cleaned_units varchar NULL,
	lod varchar(45) NULL,
	loq varchar(45) NULL,
	nd_flag varchar(100) NULL,
	result_flag varchar(500) NULL,
	detected int4 NULL,
	detect_conflict int4 NULL,
	detect_note varchar NULL,
	reported_species varchar(200) NULL,
	reported_media varchar(120) NULL,
	harmonized_medium varchar(200) NULL,
	reported_analytical_method varchar(1000) NULL,
	reported_collection_activity_id varchar(100) NULL,
	reported_sample_id varchar(100) NULL,
	mmdb_sample_id varchar NULL,
	reported_dates varchar(45) NULL,
	sample_year varchar(4) NULL,
	sample_month varchar(4) NULL,
	sample_time varchar NULL,
	reported_location varchar(250) NULL,
	state_or_province varchar NULL,
	us_county varchar(60) NULL,
	country varchar(100) NULL,
	qc_flag varchar(100) NULL,
	reported_link varchar(500) NULL,
	reported_reference varchar(300) NULL,
	data_version text NULL,
	export_date date NULL
);
