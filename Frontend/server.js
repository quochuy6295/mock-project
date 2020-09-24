const express = require('express');

const app = express();

app.use(express.static('./dist/vti-crm-frontend'));

app.get('/*', function(req, res) {
    res.sendFile('index.html', { root: 'dist/vti-crm-frontend' });
});

app.listen(process.env.PORT || 8080);