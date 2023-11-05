#!/bin/bash

#MUST BE RUN IN GIT BASH

# Get the directory of the script
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# LOGIN AND DETAILS
DB_HOST="localhost"
DB_PORT="5432"
DB_NAME="fantasy_bestiary"
DB_USER="postgres"
DB_PASSWORD="admin123"

SQL_QUERY="SELECT json_agg(
    jsonb_build_object(
        'monster_id', m.monster_id,
        'name', m.name,
        'frequency', m.frequency,
        'activity_cycle', m.activity_cycle,
        'number_appearing', m.number_appearing,
        'alignment', m.alignment,
        'armor_class', m.armor_class,
        'movement', m.movement,
        'hit_dice', m.hit_dice,
        'thaco', m.thaco,
        'attack', m.attack,
        'size', m.size,
        'morale', m.morale,
        'experience', m.experience,
        'treasures', (
            SELECT json_agg(
                jsonb_build_object(
                    'treasure_type_name', COALESCE(t.treasure_type_name, ''),
                    'copper_range', COALESCE(t.copper_range, ''),
                    'silver_range', COALESCE(t.silver_range, ''),
                    'gold_range', COALESCE(t.gold_range, ''),
                    'electrum_range', COALESCE(t.electrum_range, ''),
                    'gems_range', COALESCE(t.gems_range, ''),
                    'art_objects_range', COALESCE(t.art_objects_range, ''),
                    'item', COALESCE(t.item, ''),
                    'percentage_copper', COALESCE(t.percentage_copper, 0),
                    'percentage_silver', COALESCE(t.percentage_silver, 0),
                    'percentage_gold', COALESCE(t.percentage_gold, 0),
                    'percentage_electrum', COALESCE(t.percentage_electrum, 0),
                    'percentage_gems', COALESCE(t.percentage_gems, 0),
                    'percentage_art_objects', COALESCE(t.percentage_art_objects, 0),
                    'percentage_item', COALESCE(t.percentage_item, 0)
                )
            )
            FROM monster_treasure mt
            LEFT JOIN treasure_type t ON mt.treasure_type_id = t.treasure_type_id
            WHERE mt.monster_id = m.monster_id
        )
    )
)
FROM monster m;
"

# Output JSON file path in the parent directory of the script
OUTPUT_FILE="$SCRIPT_DIR/../fantasy_bestiary.json"

# Execute the SQL query and save the JSON data to a file
psql -h $DB_HOST -p $DB_PORT -d $DB_NAME -U $DB_USER -c "$SQL_QUERY" -t -A -o "$OUTPUT_FILE"

# Check the psql command's exit status
if [ $? -eq 0 ]; then
    echo "JSON data saved to $OUTPUT_FILE"
else
    echo "Error retrieving JSON data"
fi
