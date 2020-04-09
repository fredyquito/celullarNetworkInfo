import pymysql
from app import app
from db_config import mysql
from flask import jsonify
from flask import flash, request
		
@app.route('/add', methods=['POST'])
def add_user():
    try:
        _json = request.json
        _countryiso = _json['countryiso']
        _operatorid = _json['operatorid']
        _operatorname = _json['operatorname']
        _isconected = _json['isconected']
        _phonesignaltype = _json['phonesignaltype']
        _phonenetworktype = _json['phonenetworktype']
        _signalquality = _json['signalquality']
        _networkconectivitytype = _json['networkconectivitytype']
        _phonesignalstrength = _json['phonesignalstrength']
        _downloadmovilespeed = _json['downloadmovilespeed']
        _uploadmovilspeed = _json['uploadmovilspeed']
        _wifispeed = _json['wifispeed']
        # validate the received values
        if _countryiso and _operatorid and _operatorname and _isconected and _phonesignaltype and _phonenetworktype and _signalquality and _networkconectivitytype and _phonesignalstrength and _downloadmovilespeed and _uploadmovilspeed and _wifispeed and request.method == 'POST':
            #do not save password as a plain text
            #_hashed_password = generate_password_hash(_password)
            # save edits
            sql = "INSERT INTO cellularscantb(countryiso, operatorid, operatorname, isconected, phonesignaltype, phonenetworktype, signalquality, networkconectivitytype, phonesignalstrength, downloadmovilespeed, uploadmovilspeed, wifispeed ) VALUES(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)"
            data = (_countryiso, _operatorid, _operatorname, _isconected, _phonesignaltype, _phonenetworktype, _signalquality, _networkconectivitytype, _phonesignalstrength, _downloadmovilespeed, _uploadmovilspeed, _wifispeed,)
            conn = mysql.connect()
            cursor = conn.cursor()
            cursor.execute(sql, data)
            conn.commit()
            resp = jsonify('registro credado satisfactoriamente!')
            resp.status_code = 200
            return resp
        else:
            return not_found()
    except Exception as e:
    	print(e)
    finally:
        cursor.close() 
        conn.close()
		
@app.route('/getdata')
def users():
    try:
        conn = mysql.connect()
        cursor = conn.cursor(pymysql.cursors.DictCursor)
        cursor.execute("SELECT * FROM cellularscantb")
        rows = cursor.fetchall()
        resp = jsonify(rows)
        resp.status_code = 200
        return resp
    except Exception as e:
        print(e)
    finally:
        cursor.close() 
        conn.close()
		
@app.route('/getdata/<int:id>')
def user(id):
    try:
        conn = mysql.connect()
        cursor = conn.cursor(pymysql.cursors.DictCursor)
        cursor.execute("SELECT * FROM cellularscantb WHERE scanid=%s", id)
        row = cursor.fetchone()
        resp = jsonify(row)
        resp.status_code = 200
        return resp
    except Exception as e:
        print(e)
    finally:
        cursor.close() 
        conn.close()

@app.route('/update', methods=['POST'])
def update_user():
    try:
        _json = request.json
        _countryiso = _json['countryiso']
        _operatorid = _json['operatorid']
        _operatorname = _json['operatorname']
        _isconected = _json['isconected']
        _phonesignaltype = _json['phonesignaltype']
        _phonenetworktype = _json['phonenetworktype']
        _signalquality = _json['signalquality']
        _networkconectivitytype = _json['networkconectivitytype']
        _phonesignalstrength = _json['phonesignalstrength']
        _downloadmovilespeed = _json['downloadmovilespeed']
        _uploadmovilspeed = _json['uploadmovilspeed']
        _wifispeed = _json['wifispeed']		
        # validate the received values
        if _countryiso and _operatorid and _operatorname and _isconected and _phonesignaltype and _phonenetworktype and _signalquality and _networkconectivitytype and _phonesignalstrength and _downloadmovilespeed and _uploadmovilspeed and _wifispeed and request.method == 'POST':
            #do not save password as a plain text
            #_hashed_password = generate_password_hash(_password)
            # save edits
            sql = "UPDATE cellularscantb SET _countryiso=%s,  _operatorid=%s,  _operatorname=%s,  _isconected=%s,  _phonesignaltype=%s,  _phonenetworktype=%s,  _signalquality=%s,  _networkconectivitytype=%s,  _phonesignalstrength=%s,  _downloadmovilespeed=%s,  _uploadmovilspeed=%s,  _wifispeed=%s WHERE user_id=%s"
            data = (_countryiso, _operatorid, _operatorname, _isconected, _phonesignaltype, _phonenetworktype, _signalquality, _networkconectivitytype, _phonesignalstrength, _downloadmovilespeed, _uploadmovilspeed, _wifispeed, _id)
            conn = mysql.connect()
            cursor = conn.cursor()
            cursor.execute(sql, data)
            conn.commit()
            resp = jsonify('registro creado satisfactoriamente')
            resp.status_code = 200
            return resp
        else:
            return not_found()
    except Exception as e:
        print(e)
    finally:
        cursor.close() 
        conn.close()
		
@app.route('/delete/<int:id>')
def delete_user(id):
    try:
        conn = mysql.connect()
        cursor = conn.cursor()
        cursor.execute("DELETE FROM cellularscantb WHERE user_id=%s", (id,))
        conn.commit()
        resp = jsonify('registro borrado satisfactoriamente!')
        resp.status_code = 200
        return resp
    except Exception as e:
        print(e)
    finally:
        cursor.close() 
        conn.close()
		
@app.errorhandler(404)
def not_found(error=None):
    message = {
        'status': 404,
        'message': 'Not Found: ' + request.url,
    }
    resp = jsonify(message)
    resp.status_code = 404
    
    return resp
		
if __name__ == "__main__":
    app.run(host = '0.0.0.0',port=5005)
