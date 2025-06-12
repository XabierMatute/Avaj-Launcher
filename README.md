# Avaj-Launcher

## Overview

**Avaj-Launcher** is a Java-based simulation project that models the behavior of various aircraft interacting with dynamic weather conditions. The project is designed to demonstrate object-oriented programming principles, including inheritance, polymorphism, and encapsulation, while also showcasing advanced Java features such as file handling, exception management, and reflection.

The simulation involves aircraft navigating through changing weather conditions, with each type of aircraft reacting differently based on its unique attributes. The weather is dynamically generated using mathematical models, adding realism and complexity to the simulation.

## Features

### Simulation Mechanics
- **Aircraft Types**: Includes `Baloon`, `Helicopter`, and `JetPlane`, each with unique behaviors and reactions to weather conditions.
- **Dynamic Weather**: Weather changes dynamically based on altitude thresholds calculated using sine wave models.
- **Tower Communication**: Aircraft communicate with a weather tower to receive updates and send messages.

### Object-Oriented Design
- **Inheritance**: Aircraft types inherit common properties and methods from the `Aircraft` and `Flyable` classes.
- **Singleton Pattern**: Used for `WeatherProvider` and `AircraftFactory` to ensure centralized control and resource management.
- **Encapsulation**: Coordinates and weather data are encapsulated to ensure controlled access.

### File Handling
- **Input Parsing**: Reads simulation parameters from input files.
- **Output Logging**: Logs simulation events to an output file (`simulation.txt`).

### Error Handling
- **Validation**: Ensures input data is valid and coordinates are within acceptable ranges.
- **Exception Management**: Handles invalid input, file errors, and unexpected conditions gracefully.

## Weather Generation with Sine Waves

The weather in **Avaj-Launcher** changes dynamically based on altitude thresholds calculated using sine wave models. This approach simulates realistic weather transitions by associating specific weather conditions with altitude ranges.

### How It Works
1. **Mathematical Model**: Sine waves are used to define altitude thresholds for weather changes. The formula is:
   ```
   altitude_threshold = amplitude * sin(frequency * (sin(rotation) * longitude + cos(rotation) * latitude) + phase) + height
   ```
   - **Amplitude**: Determines the range of altitude values affected by the weather condition.
   - **Frequency**: Controls the rate of change in altitude thresholds.
   - **Rotation**: Adjusts the orientation of the sine wave relative to the coordinates.
   - **Phase**: Adds an offset to the wave, allowing different weather conditions to occur at varying altitudes.
   - **Height**: Sets a baseline altitude for the weather condition.

2. **Dynamic Weather Assignment**: The `WeatherProvider` class uses these thresholds to determine the weather condition at a given altitude. For example:
   - Above the fog threshold: Clear weather.
   - Below the rain threshold: Rain.
   - Between the rain and snow thresholds: Snow.

3. **Realism**: By combining multiple sine waves, the simulation achieves complex altitude-based weather transitions.

### Example
For determining weather based on altitude:
```java
if (coordinates.getHeight() > fogWave.getValue(coordinates)) {
    return "SUN";
} else if (coordinates.getHeight() < rainWave.getValue(coordinates)) {
    return "RAIN";
} else if (coordinates.getHeight() < snowWave.getValue(coordinates) && coordinates.getHeight() > rainWave.getValue(coordinates)) {
    return "SNOW";
} else {
    return "FOG";
}
```

## Code Structure

### Core Classes
- **Aircraft**: [`Aircraft.java`](com/frankfurtairport/avajlauncher/Aircraft.java) defines the base class for all aircraft types.
- **Flyable**: [`Flyable.java`](com/frankfurtairport/avajlauncher/Flyable.java) is an abstract class for objects that can interact with the weather tower.
- **Coordinates**: [`Coordinates.java`](com/frankfurtairport/avajlauncher/Coordinates.java) manages the position and altitude of aircraft.
- **WeatherProvider**: [`WeatherProvider.java`](com/frankfurtairport/avajlauncher/WeatherProvider.java) generates dynamic weather conditions.
- **WeatherTower**: [`WeatherTower.java`](com/frankfurtairport/avajlauncher/WeatherTower.java) acts as the central hub for weather updates.
- **Tower**: [`Tower.java`](com/frankfurtairport/avajlauncher/Tower.java) manages aircraft registration and communication.

### Aircraft Types
- **Baloon**: [`Baloon.java`](com/frankfurtairport/avajlauncher/aircrafts/Baloon.java) reacts to weather with unique messages and movement patterns.
- **Helicopter**: [`Helicopter.java`](com/frankfurtairport/avajlauncher/aircrafts/Helicopter.java) has distinct reactions to weather conditions.
- **JetPlane**: [`JetPlane.java`](com/frankfurtairport/avajlauncher/aircrafts/JetPlane.java) implements specific behaviors for different weather types.

### Utilities
- **SineWave**: [`SineWave.java`](com/frankfurtairport/avajlauncher/SineWave.java) models dynamic weather patterns using mathematical sine waves.
- **AircraftFactory**: [`AircraftFactory.java`](com/frankfurtairport/avajlauncher/AircraftFactory.java) creates aircraft instances dynamically using reflection.

### Entry Point
- **Main**: [`Main.java`](com/frankfurtairport/avajlauncher/Main.java) parses input files, initializes the simulation, and runs the weather updates.

### Scripts
- **Run Script**: [`run.sh`](run.sh) automates compilation and execution of the simulation.

## Competencies Involved

### Technical Skills
- **Java Programming**: Advanced use of Java features such as reflection, file handling, and exception management.
- **Object-Oriented Design**: Applying principles like inheritance, polymorphism, and encapsulation.
- **Mathematical Modeling**: Using sine waves to simulate altitude-based weather transitions.

### Problem-Solving
- **Input Validation**: Ensuring robust handling of invalid or unexpected input data.
- **Simulation Logic**: Designing realistic interactions between aircraft and weather systems.

### Collaboration
- **Code Organization**: Structuring the project for readability and maintainability.
- **Documentation**: Writing clear comments and a comprehensive README.

## How to Run

1. Clone the repository.
2. Use the provided script to compile and run the simulation:
   ```sh
   ./run.sh <input_file>
   ```
   If no input file is provided, the default scenario file (`scenarios/scenario.txt`) will be used.

3. View the simulation results in the output file (`simulation.txt`).

## Acknowledgments

Special thanks to the Java community for providing resources and tutorials that inspired this project.