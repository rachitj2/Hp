# HP GUI Plugin

A custom HP, Mana, and Hunger GUI plugin for Paper Minecraft 1.21.1+

## Features
- Real-time HP bar (Red hearts ❤)
- Mana bar (Blue stars ✦)
- Hunger bar (Gold chicken legs 🍗)
- Updates every tick
- Displays in action bar

## Installation

1. Download the latest JAR from [Releases](https://github.com/rachitj2/hp/releases) or [Actions](https://github.com/rachitj2/hp/actions)

2. Copy to your Paper server's `plugins/` folder:
   ```bash
   cp HPGui.jar /path/to/server/plugins/
   ```

3. Restart your server

## Requirements
- Paper 1.21.1 or higher
- Java 11+

## Customization

Edit `HPGuiPlugin.java` to customize:
- Bar symbols (❤, ✦, 🍗)
- Bar colors (ChatColor.RED, ChatColor.BLUE, ChatColor.GOLD)
- Bar length (currently 10 symbols)
- Mana value (currently static 100)

## Build from Source

```bash
git clone https://github.com/rachitj2/hp.git
cd hp
mvn clean package
```

JAR will be in `target/HPGui.jar`

## License
MIT
