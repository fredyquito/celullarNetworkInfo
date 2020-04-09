from app import app
from flaskext.mysql import MySQL

mysql = MySQL()
 
# MySQL configurations
app.config['MYSQL_DATABASE_USER'] = 'arcoteluser'
app.config['MYSQL_DATABASE_PASSWORD'] = 'Abcd.123'
app.config['MYSQL_DATABASE_DB'] = 'arcoteldb'
app.config['MYSQL_DATABASE_HOST'] = '192.168.1.50'
mysql.init_app(app)
