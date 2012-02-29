
<head>
    <title>Email List</title>

    <style type="text/css">
    table.list { width: 100%; margin-bottom: 12px; border: 1px solid #000; text-align: left; }
    table.list caption { padding-top: 6px; text-align: left; font-size: 12px; font-weight: bold; text-transform: uppercase; letter-spacing: 1px; }
    table.list tr.odd { background: #fbfbfb; }
    table.list th, table.list td { padding: 6px; border-right: 1px solid #000; }
    table.list th { border-bottom: 1px solid #000; vertical-align: top; background: #eee; line-height: 100%;}
    table.list td { border-bottom: 1px dotted #aaa; vertical-align: top; }
    </style>
</head>

<body>
<div class="body">
    <h2>PostageApp Mock messages</h2>
    <div>
        <table class="list">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Recipient</th>
                    <th>Template</th>
                    <th>Model</th>
                    <th>Country Code</th>
                </tr>
            </thead>
            <tbody>
            <g:each in="${mockMessages}" status="i" var="message">
                <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                    <td><g:formatDate date="${message.dateCreated}" format="dd/MM/yy"/></td>
                    <td>${message.recipient}</td>
                    <td>${message.template}</td>
                    <td>${message.model}</td>
                    <td>${message.countryCode}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>

</div>
</body>
