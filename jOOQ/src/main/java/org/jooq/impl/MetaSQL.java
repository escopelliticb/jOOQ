package org.jooq.impl;

import static org.jooq.SQLDialect.*;

import java.util.EnumMap;

import org.jooq.SQLDialect;

// The queries generated from the various jOOQ-meta ResultQueryDatabase types.
final class MetaSQL {
    static final EnumMap<SQLDialect, String> M_UNIQUE_KEYS = new EnumMap<>(SQLDialect.class);
    static final EnumMap<SQLDialect, String> M_SEQUENCES = new EnumMap<>(SQLDialect.class);

    static {

        M_UNIQUE_KEYS.put(FIREBIRD, "select null catalog, null schema, trim(RDB$RELATION_CONSTRAINTS.RDB$RELATION_NAME) RDB$RELATION_NAME, trim(RDB$RELATION_CONSTRAINTS.RDB$CONSTRAINT_NAME) RDB$CONSTRAINT_NAME, trim(RDB$INDEX_SEGMENTS.RDB$FIELD_NAME) RDB$FIELD_NAME, RDB$INDEX_SEGMENTS.RDB$FIELD_POSITION from RDB$RELATION_CONSTRAINTS join RDB$INDEX_SEGMENTS on RDB$INDEX_SEGMENTS.RDB$INDEX_NAME = RDB$RELATION_CONSTRAINTS.RDB$INDEX_NAME where RDB$RELATION_CONSTRAINTS.RDB$CONSTRAINT_TYPE = 'UNIQUE' order by RDB$RELATION_CONSTRAINTS.RDB$CONSTRAINT_NAME asc, RDB$INDEX_SEGMENTS.RDB$FIELD_POSITION asc");
        M_UNIQUE_KEYS.put(H2, "select INFORMATION_SCHEMA.CONSTRAINTS.TABLE_CATALOG, INFORMATION_SCHEMA.CONSTRAINTS.TABLE_SCHEMA, INFORMATION_SCHEMA.CONSTRAINTS.TABLE_NAME, INFORMATION_SCHEMA.CONSTRAINTS.CONSTRAINT_NAME, INFORMATION_SCHEMA.INDEXES.COLUMN_NAME, INFORMATION_SCHEMA.INDEXES.ORDINAL_POSITION from INFORMATION_SCHEMA.CONSTRAINTS join INFORMATION_SCHEMA.INDEXES on (INFORMATION_SCHEMA.CONSTRAINTS.TABLE_SCHEMA = INFORMATION_SCHEMA.INDEXES.TABLE_SCHEMA and INFORMATION_SCHEMA.CONSTRAINTS.TABLE_NAME = INFORMATION_SCHEMA.INDEXES.TABLE_NAME and INFORMATION_SCHEMA.CONSTRAINTS.UNIQUE_INDEX_NAME = INFORMATION_SCHEMA.INDEXES.INDEX_NAME) where (INFORMATION_SCHEMA.CONSTRAINTS.TABLE_SCHEMA in (cast(? as varchar(2147483647))) and INFORMATION_SCHEMA.CONSTRAINTS.CONSTRAINT_TYPE in ('UNIQUE')) order by INFORMATION_SCHEMA.CONSTRAINTS.TABLE_SCHEMA, INFORMATION_SCHEMA.CONSTRAINTS.CONSTRAINT_NAME, INFORMATION_SCHEMA.INDEXES.ORDINAL_POSITION");
        M_UNIQUE_KEYS.put(HSQLDB, "select INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_CATALOG, INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_SCHEMA, INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_NAME, INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_NAME, INFORMATION_SCHEMA.KEY_COLUMN_USAGE.COLUMN_NAME, INFORMATION_SCHEMA.KEY_COLUMN_USAGE.ORDINAL_POSITION from (INFORMATION_SCHEMA.KEY_COLUMN_USAGE left outer join INFORMATION_SCHEMA.TABLE_CONSTRAINTS as alias_10316587 on (INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_CATALOG = alias_10316587.CONSTRAINT_CATALOG and INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_SCHEMA = alias_10316587.CONSTRAINT_SCHEMA and INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_NAME = alias_10316587.CONSTRAINT_NAME)) where (alias_10316587.CONSTRAINT_TYPE = 'UNIQUE' and alias_10316587.TABLE_SCHEMA in (cast(? as varchar(128)))) order by INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_SCHEMA asc, INFORMATION_SCHEMA.KEY_COLUMN_USAGE.TABLE_NAME asc, INFORMATION_SCHEMA.KEY_COLUMN_USAGE.CONSTRAINT_NAME asc, INFORMATION_SCHEMA.KEY_COLUMN_USAGE.ORDINAL_POSITION asc");
        M_UNIQUE_KEYS.put(MARIADB, "select distinct null as TABLE_CATALOG, information_schema.STATISTICS.TABLE_SCHEMA, information_schema.STATISTICS.TABLE_NAME, information_schema.STATISTICS.INDEX_NAME, information_schema.STATISTICS.COLUMN_NAME, information_schema.STATISTICS.SEQ_IN_INDEX from information_schema.STATISTICS where (information_schema.STATISTICS.TABLE_SCHEMA in (?, 'ee7f6174-34f2-484b-8d81-20a4d9fc866d') and information_schema.STATISTICS.INDEX_NAME <> 'PRIMARY' and information_schema.STATISTICS.NON_UNIQUE = 0) order by information_schema.STATISTICS.TABLE_SCHEMA, information_schema.STATISTICS.TABLE_NAME, information_schema.STATISTICS.INDEX_NAME, information_schema.STATISTICS.SEQ_IN_INDEX");
        M_UNIQUE_KEYS.put(MYSQL, "select distinct null as TABLE_CATALOG, information_schema.STATISTICS.TABLE_SCHEMA, information_schema.STATISTICS.TABLE_NAME, information_schema.STATISTICS.INDEX_NAME, information_schema.STATISTICS.COLUMN_NAME, information_schema.STATISTICS.SEQ_IN_INDEX from information_schema.STATISTICS where (information_schema.STATISTICS.TABLE_SCHEMA in (?, 'ee7f6174-34f2-484b-8d81-20a4d9fc866d') and information_schema.STATISTICS.INDEX_NAME <> 'PRIMARY' and information_schema.STATISTICS.NON_UNIQUE = 0) order by information_schema.STATISTICS.TABLE_SCHEMA, information_schema.STATISTICS.TABLE_NAME, information_schema.STATISTICS.INDEX_NAME, information_schema.STATISTICS.SEQ_IN_INDEX");
        M_UNIQUE_KEYS.put(POSTGRES, "select information_schema.key_column_usage.table_catalog, information_schema.key_column_usage.table_schema, information_schema.key_column_usage.table_name, information_schema.key_column_usage.constraint_name, information_schema.key_column_usage.column_name, information_schema.key_column_usage.ordinal_position from (information_schema.key_column_usage left outer join information_schema.table_constraints as alias_99043051 on (information_schema.key_column_usage.constraint_catalog = alias_99043051.constraint_catalog and information_schema.key_column_usage.constraint_schema = alias_99043051.constraint_schema and information_schema.key_column_usage.constraint_name = alias_99043051.constraint_name)) where (alias_99043051.constraint_type = 'UNIQUE' and alias_99043051.table_schema in (?)) order by information_schema.key_column_usage.table_schema asc, information_schema.key_column_usage.table_name asc, information_schema.key_column_usage.constraint_name asc, information_schema.key_column_usage.ordinal_position asc");










        M_SEQUENCES.put(FIREBIRD, "select null catalog, null schema, trim(RDB$GENERATORS.RDB$GENERATOR_NAME) RDB$GENERATOR_NAME, 'BIGINT' type_name, null numeric_precision, null numeric_scale, 0 RDB$INITIAL_VALUE, 1 RDB$GENERATOR_INCREMENT, null min_value, null max_value, null cycle, null cache from RDB$GENERATORS order by RDB$GENERATORS.RDB$GENERATOR_NAME");
        M_SEQUENCES.put(H2, "select null catalog, INFORMATION_SCHEMA.SEQUENCES.SEQUENCE_SCHEMA, INFORMATION_SCHEMA.SEQUENCES.SEQUENCE_NAME, 'BIGINT' type_name, null precision, null scale, null start_value, nullif(INFORMATION_SCHEMA.SEQUENCES.INCREMENT, 1) INCREMENT, nullif(INFORMATION_SCHEMA.SEQUENCES.MIN_VALUE, 1) MIN_VALUE, nullif(INFORMATION_SCHEMA.SEQUENCES.MAX_VALUE, 9223372036854775807) MAX_VALUE, INFORMATION_SCHEMA.SEQUENCES.IS_CYCLE, nullif(INFORMATION_SCHEMA.SEQUENCES.CACHE, 32) CACHE from INFORMATION_SCHEMA.SEQUENCES where (INFORMATION_SCHEMA.SEQUENCES.SEQUENCE_SCHEMA in (cast(? as varchar(2147483647))) and upper(INFORMATION_SCHEMA.SEQUENCES.SEQUENCE_NAME) not like 'SYSTEM!_SEQUENCE!_%' escape '!') order by INFORMATION_SCHEMA.SEQUENCES.SEQUENCE_SCHEMA, INFORMATION_SCHEMA.SEQUENCES.SEQUENCE_NAME");
        M_SEQUENCES.put(HSQLDB, "select null as catalog, INFORMATION_SCHEMA.SEQUENCES.SEQUENCE_SCHEMA, INFORMATION_SCHEMA.SEQUENCES.SEQUENCE_NAME, INFORMATION_SCHEMA.SEQUENCES.DATA_TYPE, INFORMATION_SCHEMA.SEQUENCES.NUMERIC_PRECISION, INFORMATION_SCHEMA.SEQUENCES.NUMERIC_SCALE, INFORMATION_SCHEMA.SEQUENCES.START_WITH, INFORMATION_SCHEMA.SEQUENCES.INCREMENT, INFORMATION_SCHEMA.SEQUENCES.MINIMUM_VALUE, INFORMATION_SCHEMA.SEQUENCES.MAXIMUM_VALUE, case when INFORMATION_SCHEMA.SEQUENCES.CYCLE_OPTION is not distinct from 'YES' then true else false end as CYCLE_OPTION, null as cache from INFORMATION_SCHEMA.SEQUENCES where INFORMATION_SCHEMA.SEQUENCES.SEQUENCE_SCHEMA in (cast(? as varchar(128))) order by INFORMATION_SCHEMA.SEQUENCES.SEQUENCE_SCHEMA, INFORMATION_SCHEMA.SEQUENCES.SEQUENCE_NAME");
        M_SEQUENCES.put(POSTGRES, "select null as catalog, information_schema.sequences.sequence_schema, information_schema.sequences.sequence_name, information_schema.sequences.data_type, information_schema.sequences.numeric_precision, information_schema.sequences.numeric_scale, nullif(cast(information_schema.sequences.start_value as bigint), 1) as start_value, nullif(cast(information_schema.sequences.increment as bigint), 1) as increment, nullif(cast(information_schema.sequences.minimum_value as bigint), 1) as minimum_value, nullif(cast(information_schema.sequences.maximum_value as decimal), (power(cast(2 as decimal), cast((information_schema.sequences.numeric_precision - 1) as decimal)) - 1)) as maximum_value, cast(information_schema.sequences.cycle_option as boolean) as cycle_option, null as cache from information_schema.sequences where information_schema.sequences.sequence_schema in (?) order by information_schema.sequences.sequence_schema, information_schema.sequences.sequence_name");






    }
}
