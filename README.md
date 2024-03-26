![Midnight Lurker Logo](https://cdn.modrinth.com/data/cached_images/6c6e61b1d21c0a24dfc779829a7f49623fb86e96.png)


# An unofficial Fabric port of the [Midnight Lurker](https://modrinth.com/mod/the-midnight-lurker).

### This mod adds a new mob to the game that has a chance to spawn at night or in caves and it's main goal is to scare the player.

This Mod Does Require GeckoLib


<details>
<summary>Mob Info</summary>

### General Info:

The mob works by spawning near the player and waits for the player to find them.
Once the player finds the mob they can do one of two things

1: Look at the mob to scare it off (the mob will teleport away)

2: Get closer to the mob without looking at it which will aggravate it and make it attack the player (after about a minute or so of them chasing the player if they cannot catch the player they will teleport away) (The mob will also break the doors of a player's build if the player tries to lock the mob outside when it's aggravated unless the player's build uses iron doors)

3: The Lurker will teleport away once it has killed a player and will have a chance to walk toward the player and stop at a certain distance away

4: If the Lurker gets trapped in a boat/minecart he will immediately exit the boat/minecart

5: The Lurker has a small chance to get angry if the player looks at the Lurker and the Lurker can be invisible and follow the player

6: All Lurkers who walk or run will now be able to climb to get to the player.)

7: Any Lurker variant can be attacked directly by the player if lurker_invulnerable is set to false when this is set to false the player's shield will go on cooldown for 2.5 seconds when attacked by the Lurker so the player can't shield spam to kill the Lurker

8: The damage of the Lurker variants that can attack the player scales with the player's armor, so they are never safe, even when overpowered.

9: The Lurker will swim somewhat faster if the player is in a boat.

10: The Lurker will kill animals if the player is not near.

11: The Lurker has variants.

### Varient Specific Info

**The "Faker"**, which will spawn on insanity stage 6, will jumpscare the player and increase their insanity stage by +1.

**The "Hider"** will hide within the ground when looked at, and if the player gets too close, it will teleport away and leave behind a Void Gateway.

**The "Shadow"** will stalk the player in dark places like caves and can jumpscare the player.

**The "Unprovoked"** variant will become aggressive for unknown reasons.

**The "Shapeshifter"** will appear in villages and can deceive the player into trading with them, and if the player is tricked into trying to trade, he will proceed to attack the player, although if the player figures out who the shapeshifter is and hits him, he will transform back into the Lurker and run away.

**The "Neutral/Runaway"** will watch the player, and if the player looks at it or gets close, it will either run away or walk towards the player.

**The Void Gateway** is a portal that the Lurker can leave behind in random spots around the world. Upon interacting with the gateway, the player will either be jumpscared or rewarded by reverting an insanity stage by 1.

**When a "Neutral/Runaway"** spawns, it will start the insanity timer of the player closest. If a player kills the "Neutral/Runaway", then the insanity timer will stop, so the player is no longer progressing insanity stages.

The Neutral/Runaway Lurker will stop walking towards the player when close enough and will run away when the player gets too close

When insanity reaches stage 7, **the "Aggressive" Lurker** will spawn and chase the player down. This Lurker has different traits from the normal ones, as he can duck and crawl into spaces to reach the player. He can also break glass and doors, and if underground, tunnel toward the player if there is space for it.

**The Void Hands** are a variant of the Void Gateway, and when the player gets too close to it, it will reveal itself to the player and will then start to chase the player. The Void Hands can open doors, and once they have low enough HP, they will teleport away and jumpscare the player

**The invisible entities** have a low chance of spawning and when around the player can do certain actions which include playing a static-like jumpscare, playing cave sounds to trick the player into thinking they're being watched, following the player, watching the player, and playing Lurker running sounds as a sort of fake out.

**The "Creep"** will watch the player, but if the player attacks or goes close to it, then it will attack the player, and if the player looks at it, then it will teleport near the player instead of teleporting away.

**The "Unprovoked",  "Stare",  and Nether variants** of the Lurker can be stunned when attacked but will have a stun cooldown period where the player cannot attack them.

**The "Unprovoked"** won't always disappear when looked at.

**The "Phantom Head,"** if looked at, will slowly float towards the player, and if close, will force the player to look at it as it gets closer and closer.

**The Shapeshifter Pig and Cow** will attack the player if the player tries to kill them for food.

### Insanity and Effect Info

When the player sleeps through the night insanity will stop progressing until the next neutral Lurker spawns

The player can eat food to reduce or increase insanity the player can also fish to reduce insanity

The player will get "Amnesia" on insanity stage 6 and the Amnesia will despawn mobs if you are close to them and looking away

The Shapeshifter Pig and Cow will attack the player if the player tries to kill them for food.
The Lurker will kill animals if the player is not near.

</details>


<details>
<summary>Config Info</summary>

To use the config, you have to go into your Minecraft game directory, then go into the "config" folder and it should be there. You can edit the config with Notepad, Notepad++, or any code editor you may have installed.

Config Settings:

1: lurker_chase_music If set to true, music will play while the Lurker is chasing after you. If set to false, music will not play while the Lurker is chasing you.

2: lurker_spawn_rate If set to 1, then the spawn rate of the Lurker will be low, but if set to 5, then the spawn rate for the Lurker will be high. There are also in-between options from 2 to 3.

3: pop_up_jumpscare If set to true, a jumpscare overlay will pop up when the Lurker gets too close to you; if set to false, then the overlay will not appear.

4: jumpscare_sound If set to true, then sounds will play when you are too close to the Lurker. If set to false, then the sounds will not play.

5: longer_lurker_chase If set to true, the Lurker will chase you for around 2 minutes; if set to false, the Lurker will chase you for around 1 minute.

6: spooky_ambience If set to true, then "spooky ambience" will play. If set to false, then "spooky ambience" will not play.

7: multi_spawning If set to false, then only one Lurker will spawn within a large radius of the player; if set to true, then multiple Lurkers will be able to spawn around the player.

8: insanity_progress_effect If set to true, then the player will get the potion effect of insanity, and Lurker faces will show up around the player when the insanity stage goes up by 1. If set to false, then nothing will show or happen when the stage progresses.

9: insanity_countdown_time The insanity countdown time determines how long the timer is for insanity. 1 = 5 minutes, 2 = 10 minutes, 3 = 20 minutes, and 4 = 30 minutes.

10: lurker_invulnerable If set to false, then the Lurker will be killable when the player is hitting it directly, and when the player is hit if they are shielding, then their shield will go on cooldown for 2.5 seconds. If set to true, then the only killable lurker will be the Runaway/Neutral, and the player's shield won't go on cooldown when hit by the Lurker.


11: nether_lurker_spawn_rate If set to 1, then the spawn rate of the Nether Lurker will be low, but if set to 5, then the spawn rate for the Nether Lurker will be high. There are also in-between options from 2 to 3.

12: amnesia If set to true, then the player will gain the amnesia effect while on insanity stage 6. If set to false, then the player will not gain the amnesia effect while on insanity stage 6.

13: invisible_entities_spawning If set to true, then invisible entities that can play, sound rarely, and follow the player will be able to spawn. If set to false, then these invisible entities will not spawn.

14: encounters_progress_stages If set to true, then if you encounter the Lurker by going close to him six times, the insanity stage will go up by one. If set to false, then this will not happen.

15: If set to true, then you will see the Amnesia effect inside your inventory. If set to false, then you will not see the Amnesia effect in your inventory.

16: If set to true, then you will see the Insanity effect inside your inventory. If set to false, then you will not see the Insanity effect in your inventory.


</details>
