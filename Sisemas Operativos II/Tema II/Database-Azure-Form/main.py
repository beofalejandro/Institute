from flask import Flask, render_template, request, redirect, url_for
from sqlalchemy import create_engine, text
import logging

# Configure logging
logging.basicConfig(level=logging.DEBUG)

app = Flask(__name__)

# Credenciales de Azure
server = 'escaliav2.database.windows.net'
database = 'ESCALIA-Database'
username = 'escalia'
password = 'EF78E13306a'

engine = create_engine(f'mssql+pymssql://{username}:{password}@{server}/{database}')

@app.route('/')
def index():
    return render_template('index.html')

# Formulary method
@app.route('/submit', methods=['POST'])
def submit():
    nombre = request.form['nombre']
    apellido = request.form['apellido']
    telefono = request.form['telefono']
    edad = request.form['edad']
    semestre = request.form['semestre']

    sql = text("INSERT INTO [dbo].[USUARIO] (nombre, apellido, telefono, edad, semestre) VALUES (:nombre, :apellido, :telefono, :edad, :semestre)")

    try:
        with engine.connect() as connection:
            connection.execute(sql, {"nombre": nombre, "apellido": apellido, "telefono": telefono, "edad": edad, "semestre": semestre})
            connection.commit()
        logging.info("Data inserted successfully.")
    except Exception as e:
        logging.error("Error inserting data:", exc_info=True)
        return f"Error: {str(e)}", 500  # Internal Server Error

    return redirect(url_for('index'))

if __name__ == '__main__':
    app.run(debug=True)
