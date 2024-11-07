# Multiplayer Fighting Game

This is a simple multiplayer fighting game built with Node.js, Express, and vanilla JavaScript. It allows two players to attack and heal each other until one player's health reaches zero. The game includes sound effects for attacks and healing actions.

## Project Structure

```
FightingGameNode/
├── public/
│   ├── images/                 # Player avatars and other game visuals
│   │   ├── kyu.gif
│   │   ├── ken.gif
│   │   └── other-images...
│   ├── sounds/                 # Sound effects for game actions
│   │   ├── fastpunch.mp3
│   │   ├── fastheal.mp3
│   │   ├── quickhit.mp3
│   │   ├── quickheal.mp3
│   │   ├── victory.mp3
│   │   └── other-sounds...
│   ├── style.css               # CSS file for game styling
│   └── script.js               # JavaScript file with game logic
├── views/
│   └── index.html              # Main HTML file for the game interface
├── server.js                   # Express server setup
└── package.json                # Project metadata and dependencies
```

## Getting Started

### Prerequisites

- [Node.js](https://nodejs.org/)
- [npm (Node Package Manager)](https://www.npmjs.com/)

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/Sco8t/MultiplerFightingGame.git
   ```
2. Navigate to the project directory:
   ```sh
   cd FightingGameNode
   ```
3. Install the dependencies:
   ```sh
   npm install
   ```

### Running the Server

1. Start the server using `nodemon`:
   ```sh
   npm start
   ```
2. Open your browser and navigate to `http://localhost:3000`.

## Game Controls

- **Player 1:**
  - Attack: Press `Q`
  - Heal: Press `A`
- **Player 2:**
  - Attack: Press `P`
  - Heal: Press `L`

## Game Logic

The core game logic resides in `public/script.js` and follows these main components:

### Player Class
The `Player` class represents each player, with properties such as `name`, `health`, and `attackDmg`. It has two main methods:
- **strike**: Reduces the enemy's health by a random damage value (between 1 and 10).
- **heal**: Restores the player’s health by a random value (between 1 and 5).

Both actions (`strike` and `heal`) are triggered by specific key presses and update the game state each time they’re performed.

### Game Class
The `Game` class manages the game state and determines the winner. Key methods include:
- **updateGame**: Checks the players' health status and displays their names and health. If any player’s health drops to zero, it declares the game over and announces the winner.
- **declareWinner**: Declares the winner based on which player’s health reaches zero first, and plays the victory sound.
- **play**: Simulates random actions (attacks and heals) between the two players until one player’s health is zero. This method can be activated to simulate a non-interactive game session.

### Game Flow
- **Keyboard Controls**: The game listens for keyboard inputs to perform actions. `Q` and `P` are for attacks, while `A` and `L` trigger healing.
- **Simulation**: The play button starts an automated simulation of random attacks and heals until one player's health reaches zero.

### Example Game Logic (Excerpt from `script.js`):

```javascript
class Player {
  constructor(name, health, attackDamage) {
    this.name = name;
    this.health = health;
    this.attackDmg = attackDamage;
  }

  strike(player, enemy, attackDmg) {
    attackDmg = Math.floor(Math.random() * 10) + 1;
    enemy.health -= attackDmg;
    updateGame(player, enemy, gameState);
    return `${player.name} attacks ${enemy.name} for ${attackDmg} Damage`;
  }

  heal(player) {
    let healVal = Math.floor(Math.random() * 5) + 1;
    player.health += healVal;
    updateGame(player, enemy, gameState);
    return `${player.name} heals for ${healVal}`;
  }
}

class Game {
  updateGame(p1, p2, gameState) {
    if (p1.health <= 0 || p2.health <= 0) {
      gameState = true;
      resultDiv.innerHTML = game.declareWinner(p1, p2);
    }
  }

  declareWinner(p1, p2) {
    let resultMsg = p1.health <= 0 ? `${p2.name} WINS` : `${p1.name} WINS`;
    svictory.play();
    return resultMsg;
  }
}
```

## Files

### `server.js`

Sets up the Express server to serve static files and handle requests.

### `views/index.html`

The main HTML file for the game. It defines the structure of the game interface and includes references to the CSS and JavaScript files.

### `public/script.js`

Contains the core logic of the game, including player actions, game state updates, and event listeners for keyboard inputs.

### `public/sounds`

Directory containing sound effects for the game (attack and heal sounds).

### `public/images`

Directory containing images for player avatars and other visuals used in the game.

## Acknowledgements

- [Express](https://expressjs.com/)
- [Node.js](https://nodejs.org/)
- [GitHub](https://github.com/)

---
Enjoy playing the Multiplayer Fighting Game and feel free to contribute!
```
