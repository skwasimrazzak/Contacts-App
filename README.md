# Contacts App

This repository contains a Contacts App built using Java for Android, following the MVVM (Model-View-ViewModel) architecture. The application allows users to store and manage contacts with names and email addresses. Additionally, it features swipe-to-delete functionality.

## Features

- Store and manage contacts with names and email addresses.
- Swipe to delete contacts.
- MVVM architecture for a clean separation of concerns.

## Project Structure

The project is organized into the following files and directories:

- **app/**
  - **src/main/java/**
    - **model/**: Contains the data model classes.
      - `Contact.java`: Defines the schema for the contact data.
    - **repository/**: Contains the repository class for data operations.
      - `ContactRepository.java`: Manages data sources and provides an abstraction layer.
    - **view/**: Contains the UI components and activities.
      - `MainActivity.java`: The main activity that sets up the view elements and interactions.
      - `ContactAdapter.java`: Adapter for binding contact data to the RecyclerView.
    - **viewmodel/**: Contains the ViewModel classes.
      - `ContactViewModel.java`: Provides data to the UI and handles user interactions.
  - **src/main/res/**
    - **layout/**: Contains the XML layout files.
      - `activity_main.xml`: Layout file for the main activity.
      - `contact_item.xml`: Layout file for individual contact items.
    - **values/**: Contains XML files for resources like strings and colors.
      - `strings.xml`: Defines string resources used in the app.
      - `colors.xml`: Defines color resources used in the app.

## Setup and Installation

To run this project locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/skwasimrazzak/Contacts-App.git
   cd Contacts-App
   ```

2. **Open the project in Android Studio**:
   Open Android Studio, select "Open an existing project," and navigate to the cloned directory.

3. **Build and Run**:
   Build the project and run it on an Android device or emulator.

## Usage

- Launch the application on your Android device.
- Add contacts with names and email addresses.
- Swipe left on a contact to delete it from the list.

## Architecture Overview

This application follows the MVVM architecture, which consists of:

- **Model**: Represents the data layer of the application. In this app, `Contact.java` is the model class.
- **View**: Represents the UI layer. In this app, `MainActivity.java` and the associated XML layout files define the view.
- **ViewModel**: Acts as a bridge between the Model and the View. `ContactViewModel.java` handles data preparation for the UI and responds to user interactions.

## Contributing

Contributions are welcome! If you have any suggestions or improvements, feel free to create an issue or submit a pull request.

---

Feel free to update this README with any additional information or instructions specific to your project.
