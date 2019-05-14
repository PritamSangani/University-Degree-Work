from flask import Flask, render_template
from flask_socketio import SocketIO, emit
import json
import eliza

app = Flask(__name__)
socketio = SocketIO(app)


@app.route('/')
def index():
    return render_template('index.html')


@socketio.on('connected')
def connected(message):
    print('received json: ' + str(message))
    response, _ = eliza.analyze("Hello", {})
    emit('elizamessage', json.dumps({
        "response": response
    }))


@socketio.on('usermessage')
def user_message_received(message):
    print('received message from user: ' + str(message))
    data = json.loads(message)
    entities = data['entities']
    print(entities)
    user_message = data['message']
    response, ents = eliza.analyze(user_message, entities)

    emit('elizamessage', json.dumps({
        "message": user_message,
        "response": response,
        "entities": ents
    }))


if __name__ == '__main__':
    socketio.run(app, debug=True)
