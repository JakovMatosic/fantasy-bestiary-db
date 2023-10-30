# fantasy-bestiary-db

## Description
This repository contains monster and treasure data for the second edition of the worlds most popular fantasy roleplaying game. It is 

## Metadata
- **Data License**: OGL (Open Gaming License)
- **Software License**: MIT
- **Author**: Jakov Matošić
- **Dataset Version**: 1.0
- **Data Language**: English
- **Data Source**: second edition of the worlds most popular fantasy roleplaying game's bestiary
- **Date added**: 30.10.2023.
- **Date Updated**: 30.10.2023.
- **Tables**: monster, treasure_types, monster_treasure
- **Null-values**: values in the treasure table can be null, signifying nothing under that column.

## Columns and tables
### `monster` Table
- `monster_id`: Monster ID
- `name`: Monster Name
- `frequency`: Frequency/chance of meeting
- `activity_cycle`: Activity Cycle (time of day)
- `number_appearing`: Number Appearing
- `alignment`: Alignment (morality)
- `armor_class`: Armor Class
- `movement`: Movement
- `hit_dice`: Hit Dice
- `thaco`: THAC0 (To Hit Armor Class 0)
- `attack`: Attack
- `size`: Size
- `morale`: Morale (bravery)
- `experience`: Experience

### `treasure_type` Table
- `treasure_type_id`: Treasure Type ID
- `treasure_type_name`: Name of the Treasure Type
- `copper_range`: Range of Copper Treasures
- `silver_range`: Range of Silver Treasures
- `gold_range`: Range of Gold Treasures
- `electrum_range`: Range of Electrum Treasures
- `gems_range`: Range of Gem Treasures
- `art_objects_range`: Range of Art Object Treasures
- `item_description`: Description of Special Items
- `percentage_copper`: Percentage chance chance of Copper Treasures
- `percentage_silver`: Percentage chance chance of Silver Treasures
- `percentage_gold`: Percentage chance chance of Gold Treasures
- `percentage_electrum`: Percentage chance chance of Electrum Treasures
- `percentage_gems`: Percentage chance chance of Gem Treasures
- `percentage_art_objects`: Percentage chance chance of Art Object Treasures
- `percentage_item`: Percentage chance chance of Special Items

### `monster_treasure` Table (Many-to-Many Relationship)
- `monster_treasure_id`: Monster-Treasure Relationship ID
- `monster_id`: References `monster` table by `monster_id`
- `treasure_type_id`: References `treasure_type` table by `treasure_type_id`
