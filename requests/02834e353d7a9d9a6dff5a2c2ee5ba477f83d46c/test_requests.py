#!/usr/bin/env python
# -*- coding: utf-8 -*-


import unittest
from cStringIO import StringIO

import requests


class RequestsTestSuite(unittest.TestCase):
	"""Requests test cases."""
	
	def setUp(self):
		pass

	def tearDown(self):
		"""Teardown."""
		pass
		
	def test_invalid_url(self):
		self.assertRaises(ValueError, requests.get, 'hiwpefhipowhefopw')

	def test_HTTP_200_OK_GET(self):
		r = requests.get('http://google.com')
		self.assertEqual(r.status_code, 200)

	def test_HTTPS_200_OK_GET(self):
		r = requests.get('https://google.com')
		self.assertEqual(r.status_code, 200)

	def test_HTTP_200_OK_HEAD(self):
		r = requests.head('http://google.com')
		self.assertEqual(r.status_code, 200)

	def test_HTTPS_200_OK_HEAD(self):
		r = requests.head('https://google.com')
		self.assertEqual(r.status_code, 200)

	def test_AUTH_HTTPS_200_OK_GET(self):
		auth = requests.AuthObject('requeststest', 'requeststest')
		url = 'https://convore.com/api/account/verify.json'
		r = requests.get(url, auth=auth)

		self.assertEqual(r.status_code, 200)

	def test_POSTBIN_GET_POST_FILES(self):

		bin = requests.post('http://www.postbin.org/')
		self.assertEqual(bin.status_code, 200)

		post = requests.post(bin.url, data={'some': 'data'})
		self.assertEqual(post.status_code, 201)

		post2 = requests.post(bin.url, files={'some': StringIO('data')})
		self.assertEqual(post2.status_code, 201)



if __name__ == '__main__':
	unittest.main()
