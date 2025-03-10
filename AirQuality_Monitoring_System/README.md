# Air Quality Monitoring System
This project contains Python scripts and a Jupyter Notebook that collectively implement an Air Quality Monitoring System. The system integrates data collection, cleaning, processing, and machine learning models to monitor and predict air quality parameters.

## Project Overview

The project is organized into multiple modules, each focusing on specific aspects of air quality monitoring:

### Data Collection: 
Scripts to gather data from sensors.
http://api.openweathermap.org/data/2.5/air_pollution?lat={lat}&lon={lon}&appid={API key}
### Data Cleaning and Processing: 
Scripts to clean and process raw data.
### Machine Learning Models: 
ARIMA and LSTM models for air quality forecasting.
### Dashboard: 
A setup for database configuration and integration.

The accompanying Jupyter Notebook combines and documents all these scripts for ease of understanding and execution.
### Features

Data Collection:
Collects air quality data such as CO2, PM2.5, Humidity, and Temperature.

Data Cleaning:
Validates and cleans raw sensor data.

Data Processing:
Performs analytics and generates reports on the cleaned data.
Machine Learning Models:

ARIMA: Time series forecasting.

LSTM: Neural network-based trend prediction.

### Integrated Application:

The App.py script ties everything together for seamless operation.


### Install the required Python packages:


pip install -r requirements.txt

### Run the main application:

python Data Processing/App.py

### Usage

Use the scripts in the dashboard directory for data collection and database setup.
Utilize the Data Collection and models directories for cleaning, processing, and predictions.
Open the Jupyter Notebook (Air_Quality_Monitoring_System.ipynb) for a combined view of all functionalities.

### Demo Video

https://app.screencastify.com/v3/watch/n0OEkr3Ogy808qukVIy0


