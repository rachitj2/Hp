# HP GUI Plugin

A custom HP, Mana, and Hunger GUI plugin for Paper Minecraft 1.21.1+

## Features
- Real-time HP bar (Red hearts ❤)
- Mana bar (Blue stars ✦)
- Hunger bar (Gold chicken legs 🍗)
- Updates every tick
- Displays in action bar

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/rachitj2/hp.git
   cd hp
   ```

2. Compile with Maven:
   ```bash
   mvn clean package
   ```

3. Copy the JAR to your Paper server's `plugins/` folder:
   ```bash
   cp target/HPGui.jar /path/to/server/plugins/
   ```

4. Restart your server

## Requirements
- Paper 1.21.1 or higher
- Java 11+
- Maven (for compilation)

## Usage
Just drop the plugin in your plugins folder and restart the server. The GUI will automatically appear in the action bar for all players!

## Customization
You can edit the following in `HPGuiPlugin.java`:
- Bar symbols (❤, ✦, 🍗)
- Bar colors (ChatColor.RED, ChatColor.BLUE, ChatColor.GOLD)
- Bar length (currently 10 symbols)
- Mana value (currently static 100)

## License
MIT
