-- Create the "monster" table
CREATE TABLE monster (
    monster_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    frequency VARCHAR(15),
    activity_cycle VARCHAR(100),
    number_appearing VARCHAR(15),
    alignment VARCHAR(15),
    armor_class INT,
    movement VARCHAR(15),
    hit_dice VARCHAR(15),
    thaco INT,
    attack VARCHAR(255),
    size VARCHAR(63),
    morale VARCHAR(15),
    experience INT
);

-- Create the "treasure_type" table
CREATE TABLE treasure_type (
    treasure_type_id SERIAL PRIMARY KEY,
    treasure_type_name VARCHAR(1) NOT NULL,
    copper_range VARCHAR(20),
    silver_range VARCHAR(20),
    gold_range VARCHAR(20),
    electrum_range VARCHAR(20),
    gems_range VARCHAR(20),
    art_objects_range VARCHAR(20),
    item VARCHAR(20),
    percentage_copper INT,
    percentage_silver INT,
    percentage_gold INT,
    percentage_electrum INT,
    percentage_gems INT,
    percentage_art_objects INT,
    percentage_item INT
);

-- Create the "monster_treasure" table with many-to-many relationship
CREATE TABLE monster_treasure (
    monster_treasure_id SERIAL PRIMARY KEY,
    monster_id INT REFERENCES monster(monster_id),
    treasure_type_id INT REFERENCES treasure_type(treasure_type_id)
);